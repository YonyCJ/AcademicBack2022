package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.PeriodDto;
import com.academic.app.academicback.dto.SubPeriodDto;

import java.util.List;


public interface SubPeriodService {

    List<SubPeriodDto.Response> listarSubPeriodo();

    SubPeriodDto.Response obtenerSubPeriodoPorId(Long id);

    SubPeriodDto.Response guardarSubPeriodo(SubPeriodDto.Request request);

    void eliminarSubPeriodo(Long id);

}
