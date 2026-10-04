package com.example.career_education_advisor.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.career_education_advisor.DTO.AppointmentDTO;
import com.example.career_education_advisor.Models.Appointment;
import com.example.career_education_advisor.Repositories.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // ==========================================
    // CREATE APPOINTMENT REQUEST
    // ==========================================

    public Appointment createAppointment(AppointmentDTO dto) {

        Appointment appointment = new Appointment();

        appointment.setStudentId(dto.getStudentId());

        appointment.setCounselorId(
                dto.getCounselorId());

        appointment.setQuery(
                dto.getQuery());

        appointment.setAppointmentDate(
                dto.getAppointmentDate());

        appointment.setAppointmentTime(
                dto.getAppointmentTime());

        // Default status
        appointment.setStatus("PENDING");

        // Request creation time
        appointment.setCreatedAt(
                LocalDateTime.now());

        return appointmentRepository.save(
                appointment);
    }

    // ==========================================
    // GET STUDENT APPOINTMENTS
    // ==========================================

    public List<Appointment> getStudentAppointments(
            Long studentId) {

        return appointmentRepository
                .findByStudentId(studentId);
    }

    // ==========================================
    // GET COUNSELOR APPOINTMENTS
    // ==========================================

    public List<Appointment> getCounselorAppointments(
            Long counselorId) {

        return appointmentRepository
                .findByCounselorId(counselorId);
    }

    // ==========================================
    // GET APPOINTMENTS BY STATUS
    // ==========================================

    public List<Appointment> getAppointmentsByStatus(
            String status) {

        return appointmentRepository
                .findByStatus(status);
    }

    // ==========================================
    // UPDATE APPOINTMENT STATUS
    // ==========================================

    public Appointment updateStatus(
            Long id,
            String status) {

        Appointment appointment = appointmentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Appointment not found"));

        appointment.setStatus(status);

        return appointmentRepository.save(
                appointment);
    }

    // ==========================================
    // COUNSELOR SUGGEST NEW TIME
    // ==========================================

    public Appointment suggestNewTime(
            Long id,
            LocalDate proposedDate,
            LocalTime proposedTime) {

        Appointment appointment = appointmentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Appointment not found"));

        appointment.setProposedDate(
                proposedDate);

        appointment.setProposedTime(
                proposedTime);

        // Student needs to review
        appointment.setStatus(
                "TIME_CHANGE_REQUESTED");

        return appointmentRepository.save(
                appointment);
    }

    // ==========================================
    // STUDENT ACCEPTS PROPOSED TIME
    // ==========================================

    public Appointment acceptProposedTime(
            Long id) {

        Appointment appointment = appointmentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Appointment not found"));

        if (appointment.getProposedDate() == null ||
                appointment.getProposedTime() == null) {

            throw new RuntimeException(
                    "No proposed time found");
        }

        // Replace old time with proposed time
        appointment.setAppointmentDate(
                appointment.getProposedDate());

        appointment.setAppointmentTime(
                appointment.getProposedTime());

        // Clear proposed values
        appointment.setProposedDate(null);

        appointment.setProposedTime(null);

        // Appointment is now confirmed
        appointment.setStatus(
                "CONFIRMED");

        return appointmentRepository.save(
                appointment);
    }

    // ==========================================
    // ADD MEETING LINK
    // ==========================================

    public Appointment addMeetingLink(
            Long id,
            String meetingLink) {

        Appointment appointment = appointmentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Appointment not found"));

        appointment.setMeetingLink(
                meetingLink);

        return appointmentRepository.save(
                appointment);
    }
}