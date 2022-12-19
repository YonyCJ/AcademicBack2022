package com.academic.app.academicback.dto;

import lombok.Data;

@Data
public class AcademicChargeDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private Long id_periodo;
    private Long id_seccion;
    private Long id_grado;
    private Long id_nivel;
    private Long id_plan_academico;
}
