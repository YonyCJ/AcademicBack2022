package com.academic.app.academicback.dto;

import lombok.Getter;
import lombok.Setter;


public class StudentFinancialDto {

    @Getter
    @Setter
    public static class Response{
        private Long id;
        private PersonDto alumno;
        private RegisterDto.Response matricula;
        private Boolean estado;
    }

    @Getter
    @Setter
    public static class Request{
        private Long id;
        private Long idAlumno;
        private Long idMatricula;
        private Boolean estado;
    }


}

