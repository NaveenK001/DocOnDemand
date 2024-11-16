package com.MedLink.DocOnDemand.controller;


import com.MedLink.DocOnDemand.entities.Users;
import com.MedLink.DocOnDemand.service.EmailService;
import com.MedLink.DocOnDemand.service.UsersServiceImplementation;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

@Controller
public class RegisterController {

    @Autowired
    private UsersServiceImplementation usersServiceImplementation;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, Users users){

        modelAndView.addObject("user", users);

        modelAndView.setViewName("register");

        return modelAndView;


    }



    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid Users users, BindingResult bindingResult, HttpServletRequest httpServletRequest){

        Users userExists=usersServiceImplementation.findByEmail(users.getEmail());

        System.out.println(userExists);

        if(userExists!=null){

            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");

            modelAndView.setViewName("register");

            bindingResult.reject("email");

        }

        if(bindingResult.hasErrors()){

            modelAndView.setViewName("register");

        }

        else{

            users.setEnabled(false);

            users.setRole("ROLE_USER");

            users.setConfirmationToken(UUID.randomUUID().toString());

            usersServiceImplementation.save(users);

            String appUrl="localhost:8095";

            SimpleMailMessage registrationEmail=new SimpleMailMessage();

            registrationEmail.setTo(users.getEmail());

            registrationEmail.setSubject("Registration Confirmation");

            registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"

                                    + appUrl+"/confirm?Token="+users.getConfirmationToken());

            registrationEmail.setFrom("spring.email.auth@gmail.com");

            emailService.sendEmail(registrationEmail);

            modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to"+users.getEmail());

            modelAndView.setViewName("register");

        }

        return modelAndView;

    }



    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam("token") String token){

        Users users=usersServiceImplementation.findByConfirmationToken(token);

        if(users==null){

            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");


        }

        else {

            modelAndView.addObject("confirmationToken", users.getConfirmationToken());

        }

        modelAndView.setViewName("confirm");

        return modelAndView;

    }



    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, BindingResult bindingResult, Map<String, String> requestParams, RedirectAttributes redir){

        modelAndView.setViewName("confirm");

        Zxcvbn passwordCheck=new Zxcvbn();

        Strength strength=passwordCheck.measure(requestParams.get("password"));

        if(strength.getScore()<3){

            bindingResult.reject("password");

            redir.addAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

            modelAndView.setViewName("redirect:confirm?token="+requestParams.get("token"));

            System.out.println(requestParams.get("token"));

            return modelAndView;

        }


        Users users=usersServiceImplementation.findByConfirmationToken(requestParams.get("token"));

        users.setPassword(requestParams.get("password"));

        users.setEnabled(true);

        usersServiceImplementation.save(users);

        modelAndView.addObject("successMessage", "Your password has been set!");

        return modelAndView;

    }



}
