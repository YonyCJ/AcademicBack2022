package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.SectionDto;

import java.util.List;


public interface SectionService {

    List<SectionDto> listarSeccion();

    SectionDto obtenerSeccionPorId(Long id);

    SectionDto guardarSeccion(SectionDto request);

    void eliminarSeccion(Long id);

}
