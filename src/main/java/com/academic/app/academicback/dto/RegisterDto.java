package com.academic.app.academicback.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class RegisterDto {

    @Getter
    @Setter
    public static class Response{
        private Long id;
        private PersonDto persona;
        private AcademicChargeDto carga;
        private PeriodDto periodo;
        private GradeDto grado;
        private SectionDto seccion;
        private LevelDto nivel;
    }

    @Getter
    @Setter
    public static class Request{
        private Long id;
        private Long idAlumno;
        private Long idCargaCcademica;
        private Long idPeriodo;
        private Long idGrado;
        private Long idSeccion;
        private Long idNivel;
    }


}

