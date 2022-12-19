package com.academic.app.academicback.dto;

import lombok.Data;

@Data
public class GradeDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long id_nivel;

}
