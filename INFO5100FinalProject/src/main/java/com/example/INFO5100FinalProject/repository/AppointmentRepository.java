package com.example.INFO5100FinalProject.repository;

import com.example.INFO5100FinalProject.dao.AppointmentDao;
import com.example.INFO5100FinalProject.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AppointmentRepository implements AppointmentDao {
    private static List<Appointment> appointmentDB = new ArrayList<>();

    @Override
    public int insertAppointment(UUID id, Appointment appointment) {
        appointmentDB.add(new Appointment(id, appointment.getTime(), appointment.getService(), appointment.getPetName(), appointment.getDetail()));
        return 1;
    }

    @Override
    public List<Appointment> selectAllAppointments() {
        return appointmentDB;
    }

    @Override
    public Optional<Appointment> selectAppointmentById(UUID id) {
        return appointmentDB.stream()
                .filter(appointment -> appointment.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updateAppointmentById(UUID id, Appointment appointmentUpdateRequest) {
        return selectAppointmentById(id)
                .map(usr -> {
                    int idxToUpdate = appointmentDB.indexOf(usr);
                    if (idxToUpdate >= 0) {
                        appointmentDB.set(idxToUpdate, new Appointment(id, appointmentUpdateRequest.getTime(), appointmentUpdateRequest.getService(), appointmentUpdateRequest.getPetName(), appointmentUpdateRequest.getDetail()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deleteAppointmentById(UUID id) {
        Optional<Appointment> appointment = selectAppointmentById(id);
        if (appointment.isEmpty()) return 0;
        appointmentDB.remove(appointment.get());

        return 1;
    }
}
