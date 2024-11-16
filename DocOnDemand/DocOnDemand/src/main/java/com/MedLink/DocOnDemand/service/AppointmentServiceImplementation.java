package com.MedLink.DocOnDemand.service;

import com.MedLink.DocOnDemand.entities.Appointment;
import com.MedLink.DocOnDemand.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImplementation implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;








    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }



    @Override
    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);

    }



}
