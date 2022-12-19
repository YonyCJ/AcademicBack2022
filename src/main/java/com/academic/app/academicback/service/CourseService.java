package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {

    List<CourseDto> listarCursos();

    CourseDto obtenerCursoPorId(Long id);

    CourseDto guardarCurso(CourseDto request);

    void eliminarCurso(Long id);

}
