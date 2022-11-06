package com.theraphy.backendtheraphy.appointments.resource;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.resource.PatientResource;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateAppointmentResource {

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String scheduledDate;

    @NotNull
    @NotBlank
    @Size(max = 30)
    private String topic;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String diagnosis;

    @NotNull
    @NotBlank
    @Size(max = 10)
    private String done;

}