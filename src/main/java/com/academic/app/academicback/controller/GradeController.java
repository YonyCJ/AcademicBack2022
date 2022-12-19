package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.GradeDto;
import com.academic.app.academicback.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grade")
public class GradeController {
    @Autowired
    private GradeService service;

    @GetMapping
    public List<GradeDto> listarGrado(){
        return service.listarGrado();
    }

    @GetMapping("/{id}")
    public GradeDto listarGradoPorId(@PathVariable("id") Long id){
        return service.obtenerGradoPorId(id);
    }

    @PostMapping
    public GradeDto guardarGrado(@RequestBody GradeDto request){
        return service.guardarGrado(request);
    }


    @PutMapping
    public GradeDto actualizarGrado(@RequestBody GradeDto request){
        return service.guardarGrado(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarGrado(@PathVariable("id") Long id){
        service.eliminarGrado(id);
    }

}
