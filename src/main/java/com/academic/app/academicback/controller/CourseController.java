package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.CourseDto;
import com.academic.app.academicback.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public List<CourseDto> listarCursos(){
        return service.listarCursos();
    }


    @GetMapping("/{id}")
    public CourseDto listarCursosPorId(@PathVariable("id") Long id){

        return service.obtenerCursoPorId(id);
    }

    @PostMapping
    public CourseDto guardarCurso(@RequestBody CourseDto request){
        return service.guardarCurso(request);
    }


    @PutMapping
    public CourseDto actualizarCurso(@RequestBody CourseDto request){
        return service.guardarCurso(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable("id") Long id){
        service.eliminarCurso(id);

    }

}
