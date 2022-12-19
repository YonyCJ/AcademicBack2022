package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.PeriodDto;

import java.util.List;


public interface PeriodService {

    List<PeriodDto> listarPeriodo();

    PeriodDto obtenerPeriodoPorId(Long id);

    PeriodDto guardarPeriodo(PeriodDto request);

    void eliminarPeriodo(Long id);

}
