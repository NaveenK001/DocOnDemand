package com.MedLink.DocOnDemand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/showMyLoginPage")
    public String showhome(){

        return "login";
    }

}
