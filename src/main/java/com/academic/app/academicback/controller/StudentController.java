package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.PersonDto;
import com.academic.app.academicback.dto.StudentDto;
import com.academic.app.academicback.entity.StudentEntity;
import com.academic.app.academicback.repository.StudentRepository;
import com.academic.app.academicback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<StudentDto> listarAlumnos(){
        return service.listarAlumnos();
    }

    @GetMapping("/{id}")
    public StudentDto listarAlumnoPorId(@PathVariable("id") Long id){

        return service.obtenerAlumnoPorId(id);
    }

    @PostMapping
    public StudentDto guardarAlumno(@RequestBody StudentDto request){
        return service.guardarAlumno(request);
    }


    @PutMapping
    public StudentDto actualizarAlumno(@RequestBody StudentDto request){
        return service.guardarAlumno(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable("id") Long id){
        service.eliminarAlumno(id);

    }

}
