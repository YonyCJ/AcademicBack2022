package com.academic.app.academicback.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PersonRelationDto {

    @Getter
    @Setter
    public static class Response{
        private Long id;
        private PersonDto persona;
        private RelationShipDto parentesco;
        private Boolean estado;
    }
    @Getter
    @Setter
    public static class Request{
        private Long id;
        private Long idPersona;
        private Long idParentesco;
        private Boolean estado;
    }
}
