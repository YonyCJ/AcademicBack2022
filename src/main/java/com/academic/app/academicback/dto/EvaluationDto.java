package com.academic.app.academicback.dto;

import lombok.Data;

@Data
public class EvaluationDto {

    private Long id;
    private String nombre;
    private String porcentaje;
    private Integer numeroOrden;
    private Boolean estado;
    private Long id_carga_academica_detalle;
}
