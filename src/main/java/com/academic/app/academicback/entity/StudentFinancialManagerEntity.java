package com.academic.app.academicback.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "alumno_responsable_financiero")
public class StudentFinancialManagerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno_responsable_financiero")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "id_matricula")
    private RegisterEntity register;

    @ManyToOne
    @JoinColumn(name = "id_responsable_financiero")
    private PersonEntity financialManager;

    @Column(name = "estado")
    private Boolean condition;

}
