package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "matricula")
public class RegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "id_carga_academica")
    private AcademicChargeEntity academicCharge;

    @ManyToOne
    @JoinColumn(name = "id_periodo")
    private PeriodEntity period;

    @ManyToOne
    @JoinColumn(name = "id_grado")
    private GradeEntity grade;

    @ManyToOne
    @JoinColumn(name = "id_seccion")
    private SectionEntity section;

    @ManyToOne
    @JoinColumn(name = "id_nivel")
    private LevelEntity level;

}
