package com.theraphy.backendtheraphy.security.domain.service;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    Page<Patient> getAll(Pageable pageable);
    Patient getById(Long patientId);
    Patient create(Patient patient);
    Patient update(Long patientId, Patient request);
    ResponseEntity<?> delete(Long patientId);
    Patient addAppointmentToPatient(Long patientId, String scheduledDate,String topic, String diagnosis, String done);
}