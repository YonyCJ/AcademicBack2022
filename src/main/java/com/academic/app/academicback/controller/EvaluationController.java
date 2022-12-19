package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.EvaluationDto;
import com.academic.app.academicback.dto.PeriodDto;
import com.academic.app.academicback.entity.CourseEntity;
import com.academic.app.academicback.entity.EvaluationEntity;
import com.academic.app.academicback.repository.CourseRepository;
import com.academic.app.academicback.repository.EvaluationRepository;
import com.academic.app.academicback.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService service;

    @GetMapping
    public List<EvaluationDto> listarEvaluacion(){
        return service.listarEvaluacion();
    }


    @GetMapping("/{id}")
    public EvaluationDto listarEvaluacionPorId(@PathVariable("id") Long id){
        return service.obtenerEvaluacionPorId(id);
    }

    @PostMapping
    public EvaluationDto guardarEvaluacion(@RequestBody EvaluationDto request){
        return service.guardarEvaluacion(request);
    }


    @PutMapping
    public EvaluationDto actualizarEvaluacion(@RequestBody EvaluationDto request){
        return service.guardarEvaluacion(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarEvaluacion(@PathVariable("id") Long id){
        service.eliminarEvaluacion(id);
    }

}
