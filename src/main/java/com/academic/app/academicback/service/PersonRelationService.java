package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.PersonRelationDto;

import java.util.List;


public interface PersonRelationService {

    List<PersonRelationDto.Response> listarPersParentesco();

    PersonRelationDto.Response obtenerPersParentescoPorId(Long id);

    PersonRelationDto.Response guardarPersParentesco(PersonRelationDto.Request request);

    void eliminarPersParentesco(Long id);

}
