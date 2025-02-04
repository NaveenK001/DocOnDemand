package com.MedLink.DocOnDemand.controller;


import com.MedLink.DocOnDemand.entities.Admin;
import com.MedLink.DocOnDemand.entities.Appointment;
import com.MedLink.DocOnDemand.service.AdminServiceImplementation;
import com.MedLink.DocOnDemand.service.AppointmentServiceImplementation;
import com.MedLink.DocOnDemand.service.UsersServiceImplementation;
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
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImplementation adminServiceImplementation;

    @Autowired
    private UsersServiceImplementation usersServiceImplementation;

    @Autowired
    private AppointmentServiceImplementation appointmentServiceImplementation;


    @RequestMapping("/user-details")
    public String index(Model model){

        List<Admin> list=adminServiceImplementation.findByRole("ROLE_USER");

        model.addAttribute("user", list);

        String username="";

        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails){

            username=((UserDetails)principal).getUsername();

            String Pass=((UserDetails)principal).getPassword();

            System.out.println("One + "+username+"  "+Pass);

        }

        else {

            username=principal.toString();

            System.out.println("Two+"+username);

        }


        Admin admin=adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now=new Date();

        String log=now.toString();

        admin.setLastSeen(log);

        adminServiceImplementation.save(admin);

        return "admin/user";

    }


    @RequestMapping("/doctor-details")
    public String doctorDetails(Model model){

        String username="";

        Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails){

            username=((UserDetails)principal).getUsername();

            String Pass=((UserDetails)principal).getPassword();

            System.out.println("One +"+username+" "+Pass);

        }

        else {

            username=principal.toString();

            System.out.println("Two+"+username);

        }

        Admin admin=adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now=new Date();

        String log=now.toString();

        admin.setLastSeen(log);

        adminServiceImplementation.save(admin);

        List<Admin> list=adminServiceImplementation.findByRole("ROLE_DOCTOR");

        model.addAttribute("user", list);

        return "admin/doctor";

    }



    @RequestMapping("/admin-details")
    public String adminDetails(Model model){

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

        String log=now.toString();admin.setLastSeen(log);

        adminServiceImplementation.save(admin);

        List<Admin> list=adminServiceImplementation.findByRole("ROLE_ADMIN");

        model.addAttribute("user", list);

        return "admin/admin";

    }




    @GetMapping("/add-doctor")
    public String showFormForAdd(Model theModel) {

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

        Admin admin1 = adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now = new Date();

        String log=now.toString();

        admin1.setLastSeen(log);

        adminServiceImplementation.save(admin1);

        Admin admin = new Admin();

        theModel.addAttribute("doctor", admin);

        return "admin/addDoctor";

    }



    @PostMapping("/save-doctor")
    public String saveEmployee(@ModelAttribute("doctor") Admin admin){

        admin.setRole("ROLE_DOCTOR");

        admin.setPassword("default");

        admin.setEnabled(true);

        admin.setConfirmationToken("ByAdmin-Panel");

        System.out.println(admin);

        adminServiceImplementation.save(admin);

        return "redirect:/admin/user-details";

    }




    @GetMapping("/add-admin")
    public String showForm(Model theModel) {

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


        Admin admin1 = adminServiceImplementation.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date now = new Date();

        String log=now.toString();

        admin1.setLastSeen(log);

        adminServiceImplementation.save(admin1);

        Admin admin = new Admin();

        theModel.addAttribute("doctor", admin);

        return "admin/addAdmin";

    }



    @PostMapping("/save-admin")
    public String saveEmploye(@ModelAttribute("doctor") Admin admin) {

        admin.setRole("ROLE_ADMIN");

        admin.setPassword("default");

        admin.setEnabled(true);

        admin.setConfirmationToken("ByAdmin-Panel");

        System.out.println(admin);

        adminServiceImplementation.save(admin);

        return "redirect:/admin/user-details";

    }




    @GetMapping("/edit-my-profile")
    public String EditForm(Model theModel) {

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

        System.out.println(admin);

        theModel.addAttribute("profile", admin);

        return "admin/updateMyProfile";

    }




    @PostMapping("/update")
    public String update(@ModelAttribute("profile") Admin admin) {

        System.out.println(admin);

        adminServiceImplementation.save(admin);

        return "redirect:/admin/user-details";

    }




    @RequestMapping("/appointments")
    public String appointments(Model model){

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

        List<Appointment> list=appointmentServiceImplementation.findAll();

        model.addAttribute("app", list);

        return "admin/appointment";

    }




}





