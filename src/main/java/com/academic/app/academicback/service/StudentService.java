package com.academic.app.academicback.service;

import com.academic.app.academicback.dto.StudentDto;

import java.util.List;


public interface StudentService {

    List<StudentDto> listarAlumnos();

    StudentDto obtenerAlumnoPorId(Long id);

    StudentDto guardarAlumno(StudentDto request);

    void eliminarAlumno(Long id);

}
