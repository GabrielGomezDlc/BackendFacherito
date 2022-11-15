package com.theraphy.backendtheraphy.profile.resource;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePhysiotherapistResource {
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String lastName;

    @Min(18)
    private int age;

    @NotNull
    @NotBlank
    private String location;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String photoUrl;

    @NotNull
    @NotBlank
    private String birthdayDate;
}