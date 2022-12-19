package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sub_periodo")
public class SubPeriodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_periodo")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "tipo")
    private String type;

    @Column(name = "estado")
    private boolean condition;

    @ManyToOne
    @JoinColumn(name = "id_periodo")
    private PeriodEntity period;

}
