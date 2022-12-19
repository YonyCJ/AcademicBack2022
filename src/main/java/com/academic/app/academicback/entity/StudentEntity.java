package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "alumno")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    @Column(name = "id_alumno")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private PersonEntity person;

    @Column(name = "codigo")
    private Integer code;

    @Column(name = "estado")
    private boolean condition = false;





}
