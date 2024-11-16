package com.MedLink.DocOnDemand.service;

import com.MedLink.DocOnDemand.entities.Users;
import org.springframework.stereotype.Service;

import java.util.List;



public interface UsersService {


    Users findByConfirmationToken(String confirmationToken);


    Users findByEmail(String email);


    List<Users> findAll();


    void save(Users users);





}
