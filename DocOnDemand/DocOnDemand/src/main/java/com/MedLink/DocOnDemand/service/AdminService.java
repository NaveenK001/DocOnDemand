package com.MedLink.DocOnDemand.service;

import com.MedLink.DocOnDemand.entities.Admin;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {


    List<Admin> findByRole(String role);


    Admin findByEmail(String email);


    List<Admin> findAll();


    void save(Admin admin);



}
