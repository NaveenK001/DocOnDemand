package com.MedLink.DocOnDemand.service;

import com.MedLink.DocOnDemand.entities.Users;
import com.MedLink.DocOnDemand.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImplementation implements UsersService{

    @Autowired
    private UsersRepository usersRepository;







    @Override
    public Users findByConfirmationToken(String confirmationToken) {
        return usersRepository.findByConfirmationToken(confirmationToken);
    }




    @Override
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }




    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }




    @Override
    public void save(Users users) {
        usersRepository.save(users);

    }



}
