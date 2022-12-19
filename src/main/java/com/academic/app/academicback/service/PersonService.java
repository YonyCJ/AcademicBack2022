package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.PersonDto;

import java.util.List;


public interface PersonService {

    List<PersonDto> listarPersonas();

    PersonDto obtenerPersonaPorId(Long id);

    PersonDto guardarPersona(PersonDto request);

    void eliminarPersona(Long id);

}
