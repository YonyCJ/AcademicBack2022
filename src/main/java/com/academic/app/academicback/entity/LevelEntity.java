package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "nivel")
public class LevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private boolean condition;

}
