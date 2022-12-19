package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "carga_academica")
public class AcademicChargeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carga_academica")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private boolean condition;

    @ManyToOne
    @JoinColumn(name = "id_periodo")
    private PeriodEntity period;

    @ManyToOne
    @JoinColumn(name = "id_seccion")
    private SectionEntity section;

    @ManyToOne
    @JoinColumn(name = "id_grado")
    private GradeEntity grade;

    @ManyToOne
    @JoinColumn(name = "id_nivel")
    private LevelEntity level;

    @ManyToOne
    @JoinColumn(name = "id_plan_academico")
    private AcademicPlanEntity academicPlan;

}
