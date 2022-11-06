package com.theraphy.backendtheraphy.security.resource;

import com.theraphy.backendtheraphy.appointments.domain.model.entity.Appointment;
import com.theraphy.backendtheraphy.appointments.resource.AppointmentResource;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PatientResource {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String photoUrl;
    private String birthdayDate;
}