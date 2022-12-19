package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "persona")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id;

    @Column(name = "nombres")
    private String name;

    @Column(name = "apellido_paterno")
    private String lastName;

    @Column(name = "apellido_materno")
    private String lastNameM;



}
