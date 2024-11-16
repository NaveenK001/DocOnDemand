package com.MedLink.DocOnDemand.service;

import com.MedLink.DocOnDemand.entities.Admin;
import com.MedLink.DocOnDemand.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImplementation implements AdminService{

    @Autowired
    private AdminRepository adminRepository;





    @Override
    public List<Admin> findByRole(String role) {
        return adminRepository.findByRole(role);
    }



    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }



    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }



    @Override
    public void save(Admin admin) {
          adminRepository.save(admin);
    }


}
