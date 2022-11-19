package com.theraphy.backendtheraphy.profile.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PhysiotherapistResource {
    private Long id;
    private String firstName;
    private String paternalSurname;
    private String maternalSurname;
    private int age;
    private Double rating;
    private String location;
    private String photoUrl;
    private String birthdayDate;
    private Long consultationsQuantity;
    private String specialization;
    private String email;
}