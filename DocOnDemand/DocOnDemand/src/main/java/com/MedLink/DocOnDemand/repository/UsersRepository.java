package com.MedLink.DocOnDemand.repository;


import com.MedLink.DocOnDemand.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Integer>{


    Users findByEmail(String email);


    Users findByConfirmationToken(String confirmationToken);


    List<Users> findAll();


}
