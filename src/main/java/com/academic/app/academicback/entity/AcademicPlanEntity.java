package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "plan_academico")
public class AcademicPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan_academico")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "estado")
    private boolean condition = false;

}
