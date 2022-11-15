package com.theraphy.backendtheraphy.treatments.domain.model.entity;

import com.theraphy.backendtheraphy.profile.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.profile.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.shared.domain.model.AuditModel;
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
@Table(name = "treatments")
public class Treatment extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 50)
    @Column(unique = true)
    private String title;

    @NotBlank
    @NotNull
    @Size(max = 200)
    private String description;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "sessions_quantity")
    private int sessionsQuantity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "physiotherapist_id", nullable = false)
    private Physiotherapist physiotherapist;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, mappedBy = "treatment")
    private Set<TreatmentPatient> treatments = new HashSet<>();

    public Treatment addTreatmentPatient(Date registrationDate, Double progress){
        // Initialize if null
        if(treatments == null) {
            treatments = new HashSet<>();
        }

        // Add Criterion to Skill
        treatments.add(new TreatmentPatient()
                .withProgress(progress)
                .withRegistrationDate(registrationDate)
                .withTreatment(this));

        return this;
    }
}