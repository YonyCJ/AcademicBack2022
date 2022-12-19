package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.RegisterDto;

import java.util.List;


public interface RegisterService {

    List<RegisterDto.Response> listarMatricula();

    RegisterDto.Response obtenerMatriculaPorId(Long id);

    RegisterDto.Response guardarMatricula(RegisterDto.Request request);

    void eliminarMatricula(Long id);

}
