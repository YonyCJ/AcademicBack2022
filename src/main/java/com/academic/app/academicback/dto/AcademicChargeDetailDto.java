package com.academic.app.academicback.dto;

import lombok.Data;

@Data
public class AcademicChargeDetailDto {

    private Long id;
    private Long id_curso;
    private String descripcion;
    private Boolean estado;
    private Long id_docente;
    private String aula;
    private Integer cupo;

}
