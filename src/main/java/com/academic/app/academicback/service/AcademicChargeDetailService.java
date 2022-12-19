package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.AcademicChargeDetailDto;

import java.util.List;


public interface AcademicChargeDetailService {

    List<AcademicChargeDetailDto> listarCargaDetalle();

    AcademicChargeDetailDto obtenerCargaDetallePorId(Long id);

    AcademicChargeDetailDto guardarCargaDetalle(AcademicChargeDetailDto request);

    void eliminarCargaDetalle(Long id);

}
