package com.academic.app.academicback.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeriodDto {

    private Long id;
    private String name;
    private String descripcion;
    private Boolean estado;

}
