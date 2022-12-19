package com.academic.app.academicback.dto;

import com.academic.app.academicback.entity.PeriodEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class SubPeriodDto {
    @Getter
    @Setter
    public static class Response{
        private Long id;
        private String nombre;
        private String tipo;
        private PeriodDto periodo;
        private Boolean estado;
    }

    @Getter
    @Setter
    public static class Request{
        private Long id;
        private String nombre;
        private String tipo;
        private Long id_periodo;
        private Boolean estado;
    }



}
