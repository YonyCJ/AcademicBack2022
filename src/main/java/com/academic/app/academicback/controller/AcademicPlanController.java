package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.AcademicPlanDto;
import com.academic.app.academicback.dto.PersonDto;
import com.academic.app.academicback.entity.AcademicChargeEntity;
import com.academic.app.academicback.entity.AcademicPlanEntity;
import com.academic.app.academicback.repository.AcademicChargeRepository;
import com.academic.app.academicback.repository.AcademicPlanRepository;
import com.academic.app.academicback.service.AcademicPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/academicPlan")
public class AcademicPlanController {
    @Autowired
    private AcademicPlanService service;

    @GetMapping
    public List<AcademicPlanDto> listarPlan(){
        return service.listarPlan();
    }

    @GetMapping("/{id}")
    public AcademicPlanDto listarPlanPorId(@PathVariable("id") Long id){
        return service.obtenerPlanPorId(id);
    }

    @PostMapping
    public AcademicPlanDto guardarPlan(@RequestBody AcademicPlanDto request){
        return service.guardarPlan(request);
    }


    @PutMapping
    public AcademicPlanDto actualizarPlan(@RequestBody AcademicPlanDto request){
        return service.guardarPlan(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarPlan(@PathVariable("id") Long id){
        service.eliminarPlan(id);

    }

}
