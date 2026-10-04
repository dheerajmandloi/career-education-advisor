package com.example.career_education_advisor.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.career_education_advisor.Models.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByStudentId(Long studentId);

    List<Appointment> findByCounselorId(Long counselorId);

    List<Appointment> findByStatus(String status);
}