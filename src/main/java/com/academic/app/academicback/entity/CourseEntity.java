package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "curso")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_plan_academico")
    private AcademicPlanEntity academicPlan;

    @Column(name = "credito")
    private Integer credit;

    @Column(name = "estado")
    private Boolean condition = false;

}
