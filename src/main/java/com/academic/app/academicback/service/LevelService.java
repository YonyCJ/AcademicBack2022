package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.LevelDto;

import java.util.List;


public interface LevelService {

    List<LevelDto> listarNivel();

    LevelDto obtenerNivelPorId(Long id);

    LevelDto guardarNivel(LevelDto request);

    void eliminarNivel(Long id);

}
