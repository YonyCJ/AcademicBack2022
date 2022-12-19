package com.academic.app.academicback.dto;

import lombok.Data;

@Data
public class SectionDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long id_docente;
    private Long id_grado;

}
