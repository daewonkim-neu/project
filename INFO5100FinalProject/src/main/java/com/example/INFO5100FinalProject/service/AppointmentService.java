package com.example.INFO5100FinalProject.service;

import com.example.INFO5100FinalProject.dao.AppointmentDao;
import com.example.INFO5100FinalProject.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {
    private final AppointmentDao appointmentDao;

    @Autowired
    public AppointmentService(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public int insertAppointment(Appointment appointment) {
        return appointmentDao.insertAppointment(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentDao.selectAllAppointments();
    }

    public Optional<Appointment> selectAppointmentById(UUID id) {
        return appointmentDao.selectAppointmentById(id);
    }

    public int updateAppointmentById(UUID id, Appointment appointment) {
        return appointmentDao.updateAppointmentById(id, appointment);
    }

    public int deleteAppointmentById(UUID id) {
        return appointmentDao.deleteAppointmentById(id);
    }
}
