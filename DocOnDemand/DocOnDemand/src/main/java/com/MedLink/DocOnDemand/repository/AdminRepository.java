package com.MedLink.DocOnDemand.repository;


import com.MedLink.DocOnDemand.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, Integer>{


    Admin findByEmail(String email);


    List<Admin> findByRole(String role);


}
