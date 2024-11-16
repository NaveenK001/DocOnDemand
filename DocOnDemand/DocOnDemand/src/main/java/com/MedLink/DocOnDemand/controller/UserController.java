package com.MedLink.DocOnDemand.controller;


import com.MedLink.DocOnDemand.entities.Admin;
import com.MedLink.DocOnDemand.entities.Appointment;
import com.MedLink.DocOnDemand.service.AdminServiceImplementation;
import com.MedLink.DocOnDemand.service.AppointmentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AppointmentServiceImplementation appointmentServiceImplementation;

    @Autowired
    private AdminServiceImplementation adminServiceImplementation;



    @GetMapping("/index")
    public String index(Model model){

        String username="";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {

            username = ((UserDetails)principal).getUsername();

            String Pass = ((UserDetails)principal).getPassword();

            System.out.println("One + "+username+"   "+Pass);

        }

        else {

            username = principal.toString();

            System.out.println("Two + "+username);

        }


        Admin admin = adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now = new Date();

        String log=now.toString();

        admin.setLastSeen(log);

        adminServiceImplementation.save(admin);

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());

        obj.setEmail(admin.getEmail());

        System.out.println(obj);

        model.addAttribute("app",obj);

        return "user/index";

    }



    @PostMapping("/save-app")
    public String saveEmploye(@ModelAttribute("app") Appointment obj) {

        appointmentServiceImplementation.save(obj);

        return "redirect:/user/index";

    }



    @GetMapping("/about")
    public String about(Model model){

        String username="";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {

            username = ((UserDetails)principal).getUsername();

            String Pass = ((UserDetails)principal).getPassword();

            System.out.println("One + "+username+"   "+Pass);

        }

        else {

            username = principal.toString();

            System.out.println("Two + "+username);

        }


        Admin admin = adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now = new Date();

        String log=now.toString();

        admin.setLastSeen(log);

        adminServiceImplementation.save(admin);

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());

        obj.setEmail(admin.getEmail());

        System.out.println(obj);

        model.addAttribute("app",obj);

        return "user/about";

    }



    @GetMapping("/blog-single")
    public String bs(Model model){

        String username="";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {

            username = ((UserDetails)principal).getUsername();

            String Pass = ((UserDetails)principal).getPassword();

            System.out.println("One + "+username+"   "+Pass);

        }

        else {

            username = principal.toString();

            System.out.println("Two + "+username);

        }



        Admin admin = adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now = new Date();

        String log=now.toString();

        admin.setLastSeen(log);

        adminServiceImplementation.save(admin);

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());

        obj.setEmail(admin.getEmail());

        System.out.println(obj);

        model.addAttribute("app",obj);

        return "user/blog-single";

    }

    @GetMapping("/blog")
    public String blog(Model model){

        String username="";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {

            username = ((UserDetails)principal).getUsername();

            String Pass = ((UserDetails)principal).getPassword();

            System.out.println("One + "+username+"   "+Pass);

        }

        else {

            username = principal.toString();

            System.out.println("Two + "+username);

        }


        Admin admin = adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now = new Date();

        String log=now.toString();

        admin.setLastSeen(log);

        adminServiceImplementation.save(admin);

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());

        obj.setEmail(admin.getEmail());

        System.out.println(obj);

        model.addAttribute("app",obj);

        return "user/blog";

    }



    @GetMapping("/contact")
    public String contact(Model model){

        String username="";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {

            username = ((UserDetails)principal).getUsername();

            String Pass = ((UserDetails)principal).getPassword();

            System.out.println("One + "+username+"   "+Pass);

        }

        else {

            username = principal.toString();

            System.out.println("Two + "+username);

        }



        Admin admin = adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now = new Date();

        String log=now.toString();

        admin.setLastSeen(log);

        adminServiceImplementation.save(admin);

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());

        obj.setEmail(admin.getEmail());

        System.out.println(obj);

        model.addAttribute("app",obj);

        return "user/contact";

    }




    @GetMapping("/department-single")
    public String d(Model model){

        String username="";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {

            username = ((UserDetails)principal).getUsername();

            String Pass = ((UserDetails)principal).getPassword();

            System.out.println("One + "+username+"   "+Pass);

        }

        else {

            username = principal.toString();

            System.out.println("Two + "+username);

        }


        Admin admin = adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now = new Date();

        String log=now.toString();

        admin.setLastSeen(log);

        adminServiceImplementation.save(admin);

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());

        obj.setEmail(admin.getEmail());

        System.out.println(obj);

        model.addAttribute("app",obj);

        return "user/department-single";

    }



    @GetMapping("/departments")
    public String dep(Model model){

        String username="";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {

            username = ((UserDetails)principal).getUsername();

            String Pass = ((UserDetails)principal).getPassword();

            System.out.println("One + "+username+"   "+Pass);

        }

        else {

            username = principal.toString();

            System.out.println("Two + "+username);

        }



        Admin admin = adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now = new Date();

        String log=now.toString();

        admin.setLastSeen(log);

        adminServiceImplementation.save(admin);

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());

        obj.setEmail(admin.getEmail());

        System.out.println(obj);

        model.addAttribute("app",obj);

        return "user/departments";

    }



    @GetMapping("doctor")
    public String doctor(Model model){

        String username="";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {

            username = ((UserDetails)principal).getUsername();

            String Pass = ((UserDetails)principal).getPassword();

            System.out.println("One + "+username+"   "+Pass);

        }

        else {

            username = principal.toString();

            System.out.println("Two + "+username);

        }


        Admin admin = adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now = new Date();

        String log=now.toString();

        admin.setLastSeen(log);

        adminServiceImplementation.save(admin);

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());

        obj.setEmail(admin.getEmail());

        System.out.println(obj);

        model.addAttribute("app",obj);

        return "user/doctor";

    }






}
