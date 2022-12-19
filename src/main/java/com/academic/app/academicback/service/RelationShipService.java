package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.RelationShipDto;
import com.academic.app.academicback.dto.StudentDto;

import java.util.List;


public interface RelationShipService {

    List<RelationShipDto> listarParentesco();

    RelationShipDto obtenerParentescoPorId(Long id);

    RelationShipDto guardarParentesco(RelationShipDto request);

    void eliminarParentesco(Long id);

}
