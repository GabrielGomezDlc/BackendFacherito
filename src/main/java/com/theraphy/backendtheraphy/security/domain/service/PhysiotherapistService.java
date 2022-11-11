package com.theraphy.backendtheraphy.security.domain.service;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PhysiotherapistService {
    List<Physiotherapist> getAll();
    Page<Physiotherapist> getAll(Pageable pageable);
    Physiotherapist getById(Long physiotherapistId);
    Physiotherapist create(Physiotherapist physiotherapist);
    Physiotherapist update(Long physiotherapistId, Physiotherapist request);
    ResponseEntity<?> delete(Long physiotherapistId);
    Physiotherapist addAppointmentToPhysiotherapist(Long physiotherapistId, String scheduledDate,String topic, String diagnosis, String done);

}