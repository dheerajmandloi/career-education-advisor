package com.example.career_education_advisor.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.career_education_advisor.DTO.AppointmentDTO;
import com.example.career_education_advisor.Models.Appointment;
import com.example.career_education_advisor.Services.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // ==========================================
    // CREATE APPOINTMENT REQUEST
    // ==========================================

    @PostMapping
    public ResponseEntity<?> createAppointment(
            @RequestBody AppointmentDTO dto) {

        try {

            Appointment appointment = appointmentService
                    .createAppointment(dto);

            return ResponseEntity.ok(
                    appointment);

        } catch (Exception e) {

            return ResponseEntity
                    .status(500)
                    .body(
                            "Error creating appointment: "
                                    + e.getMessage());
        }
    }

    // ==========================================
    // GET STUDENT APPOINTMENTS
    // ==========================================

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Appointment>> getStudentAppointments(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                appointmentService
                        .getStudentAppointments(
                                studentId));
    }

    // ==========================================
    // GET COUNSELOR APPOINTMENTS
    // ==========================================

    @GetMapping("/counselor/{counselorId}")
    public ResponseEntity<List<Appointment>> getCounselorAppointments(
            @PathVariable Long counselorId) {

        return ResponseEntity.ok(
                appointmentService
                        .getCounselorAppointments(
                                counselorId));
    }

    // ==========================================
    // GET APPOINTMENTS BY STATUS
    // ==========================================

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Appointment>> getAppointmentsByStatus(
            @PathVariable String status) {

        return ResponseEntity.ok(
                appointmentService
                        .getAppointmentsByStatus(
                                status));
    }

    // ==========================================
    // UPDATE APPOINTMENT STATUS
    // ==========================================

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        try {

            Appointment appointment = appointmentService
                    .updateStatus(
                            id,
                            status);

            return ResponseEntity.ok(
                    appointment);

        } catch (Exception e) {

            return ResponseEntity
                    .status(500)
                    .body(
                            "Error updating status: "
                                    + e.getMessage());
        }
    }

    // ==========================================
    // COUNSELOR SUGGEST NEW TIME
    // ==========================================

    @PutMapping("/{id}/suggest-time")
    public ResponseEntity<?> suggestNewTime(
            @PathVariable Long id,
            @RequestBody AppointmentDTO dto) {

        try {

            Appointment appointment = appointmentService
                    .suggestNewTime(
                            id,
                            dto.getAppointmentDate(),
                            dto.getAppointmentTime());

            return ResponseEntity.ok(
                    appointment);

        } catch (Exception e) {

            return ResponseEntity
                    .status(500)
                    .body(
                            "Error suggesting new time: "
                                    + e.getMessage());
        }
    }

    // ==========================================
    // STUDENT ACCEPTS PROPOSED TIME
    // ==========================================

    @PutMapping("/{id}/accept-proposed-time")
    public ResponseEntity<?> acceptProposedTime(
            @PathVariable Long id) {

        try {

            Appointment appointment = appointmentService
                    .acceptProposedTime(id);

            return ResponseEntity.ok(
                    appointment);

        } catch (Exception e) {

            return ResponseEntity
                    .status(500)
                    .body(
                            "Error accepting proposed time: "
                                    + e.getMessage());
        }
    }

    // ==========================================
    // ADD MEETING LINK
    // ==========================================

    @PutMapping("/{id}/meeting-link")
    public ResponseEntity<?> addMeetingLink(
            @PathVariable Long id,
            @RequestParam String meetingLink) {

        try {

            Appointment appointment = appointmentService
                    .addMeetingLink(
                            id,
                            meetingLink);

            return ResponseEntity.ok(
                    appointment);

        } catch (Exception e) {

            return ResponseEntity
                    .status(500)
                    .body(
                            "Error adding meeting link: "
                                    + e.getMessage());
        }
    }
}