package com.theraphy.backendtheraphy.security.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
import com.theraphy.backendtheraphy.shared.exception.ResourceValidationException;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "last_name")
    private String lastName;

    private int age;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "photo_url")
    private String photoUrl;

    @NotNull
    @NotBlank
    @Column(name = "birthday_date")
    private String birthdayDate;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER, mappedBy = "patient")
    private Set<Appointment> appointments = new HashSet<>();

    public Patient addAppointment(String scheduledDate,String topic, String diagnosis, String done){
        // Initialize if null
        if(appointments == null) {
            appointments = new HashSet<>();
        }

        // Validate Criterion Name uniqueness for Skill
        if(!appointments.isEmpty()) {
            if (appointments.stream().anyMatch(patient -> patient.getScheduledDate().equals(scheduledDate)))
                throw new ResourceValidationException("Criterion", "A criterion with the same name already exists");
        }

        // Add Criterion to Skill
        appointments.add(new Appointment()
                .withScheduledDate(scheduledDate)
                .withTopic(topic)
                .withDiagnosis(diagnosis)
                .withDone(done)
                .withPatient(this));

        return this;
    }
}
