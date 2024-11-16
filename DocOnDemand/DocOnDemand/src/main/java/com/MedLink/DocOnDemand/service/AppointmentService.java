package com.MedLink.DocOnDemand.service;

import com.MedLink.DocOnDemand.entities.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;



public interface AppointmentService {


    List<Appointment> findAll();


    void save(Appointment appointment);



}
