package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.StudentFinancialDto;

import java.util.List;


public interface StudentFinancialService {

    List<StudentFinancialDto.Response> listarFinanciero();

    StudentFinancialDto.Response obtenerFinancieroPorId(Long id);

    StudentFinancialDto.Response guardarFinanciero(StudentFinancialDto.Request request);

    void eliminarFinanciero(Long id);

}
