package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.AcademicChargeDto;

import java.util.List;


public interface AcademicChargeService {

    List<AcademicChargeDto> listarCarga();

    AcademicChargeDto obtenerCargaPorId(Long id);

    AcademicChargeDto guardarCarga(AcademicChargeDto request);

    void eliminarCarga(Long id);

}
