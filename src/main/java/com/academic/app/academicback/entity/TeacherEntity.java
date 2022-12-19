package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "docente")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private PersonEntity person;

    @Column(name = "estado")
    private boolean condition = false;



}
