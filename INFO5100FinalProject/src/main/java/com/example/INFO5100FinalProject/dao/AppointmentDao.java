package com.example.INFO5100FinalProject.dao;

import com.example.INFO5100FinalProject.model.Appointment;
import com.example.INFO5100FinalProject.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentDao {

    int insertAppointment(UUID id, Appointment appointment);

    default int insertAppointment(Appointment appointment) {
        UUID id = UUID.randomUUID();
        return insertAppointment(id, appointment);
    }

    List<Appointment> selectAllAppointments();

    Optional<Appointment> selectAppointmentById(UUID id);

    int updateAppointmentById(UUID id, Appointment appointment);

    int deleteAppointmentById(UUID id);
}
