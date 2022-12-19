package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "criterio_evaluacion")
public class EvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_criterio_evaluacion")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "porcentaje")
    private String percentage;

    @Column(name = "num_orden")
    private Integer numberOrder;

    @Column(name = "estado")
    private Boolean condition;

    @ManyToOne
    @JoinColumn(name = "id_carga_academica_detalle")
    private AcademicChargeDetailEntity academicChargeDetail;

}
