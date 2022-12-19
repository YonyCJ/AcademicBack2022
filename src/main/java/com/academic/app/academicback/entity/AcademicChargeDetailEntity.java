package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "carga_academica_detalle")
public class AcademicChargeDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carga_academica_detalle")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private CourseEntity course;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private Boolean condition;

    @ManyToOne
    @JoinColumn(name = "id_docente")
    private TeacherEntity teacher;

    @Column(name = "aula")
    private String classroom;

    @Column(name = "cupo")
    private Integer quota;

}
