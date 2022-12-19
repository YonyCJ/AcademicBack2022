package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.AcademicPlanDto;
import com.academic.app.academicback.dto.CourseDto;

import java.util.List;


public interface AcademicPlanService {

    List<AcademicPlanDto> listarPlan();

    AcademicPlanDto obtenerPlanPorId(Long id);

    AcademicPlanDto guardarPlan(AcademicPlanDto request);

    void eliminarPlan(Long id);

}
