package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "persona_parentesco")
public class PersonRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona_parentesco")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "id_parentesco")
    private RelationshipEntity relationship;

    @Column(name = "estado")
    private Boolean condition;
}
