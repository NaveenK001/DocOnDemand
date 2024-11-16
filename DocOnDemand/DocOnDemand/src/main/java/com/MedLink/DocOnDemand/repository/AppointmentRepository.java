package com.MedLink.DocOnDemand.repository;


import com.MedLink.DocOnDemand.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
}
