package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.EvaluationDto;

import java.util.List;


public interface EvaluationService {

    List<EvaluationDto> listarEvaluacion();

    EvaluationDto obtenerEvaluacionPorId(Long id);

    EvaluationDto guardarEvaluacion(EvaluationDto request);

    void eliminarEvaluacion(Long id);

}
