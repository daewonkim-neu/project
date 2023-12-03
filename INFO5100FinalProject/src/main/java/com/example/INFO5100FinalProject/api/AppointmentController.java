package com.example.INFO5100FinalProject.api;

import com.example.INFO5100FinalProject.model.Appointment;
import com.example.INFO5100FinalProject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/appointment")
@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public void addAppointment(@RequestBody Appointment appointment) {
        appointmentService.insertAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping(path = "{id}")
    public Appointment getAppointmentById(@PathVariable("id") UUID id) {
        return appointmentService.selectAppointmentById(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")
    public int updateAppointmentById(@PathVariable("id") UUID id, @RequestBody Appointment appointment) {
        return appointmentService.updateAppointmentById(id, appointment);
    }

    @DeleteMapping(path = "{id}")
    public int deleteAppointmentById(@PathVariable("id") UUID id) {
        return appointmentService.deleteAppointmentById(id);
    }
}
