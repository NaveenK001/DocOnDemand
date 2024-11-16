package com.MedLink.DocOnDemand.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {



        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());


        if(roles.contains("ROLE_ADMIN")){

            httpServletResponse.sendRedirect("/admin/user-details");

        }

        if(roles.contains("ROLE_DOCTOR")){

            httpServletResponse.sendRedirect("/static/css/doctor/index");

        }

        if(roles.contains("ROLE_USER")){

            httpServletResponse.sendRedirect("/user/index");
        }


    }
}
