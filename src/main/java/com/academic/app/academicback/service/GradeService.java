package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.GradeDto;

import java.util.List;


public interface GradeService {

    List<GradeDto> listarGrado();

    GradeDto obtenerGradoPorId(Long id);

    GradeDto guardarGrado(GradeDto request);

    void eliminarGrado(Long id);

}
