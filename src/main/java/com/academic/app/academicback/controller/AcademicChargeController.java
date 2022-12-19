package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.AcademicChargeDto;
import com.academic.app.academicback.service.AcademicChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/charge")
public class AcademicChargeController {
    @Autowired
    private AcademicChargeService service;

    @GetMapping
    public List<AcademicChargeDto> listarCarga(){
        return service.listarCarga();
    }

    @GetMapping("/{id}")
    public AcademicChargeDto listarCargaPorId(@PathVariable("id") Long id){
        return service.obtenerCargaPorId(id);
    }

    @PostMapping
    public AcademicChargeDto guardarCarga(@RequestBody AcademicChargeDto request){
        return service.guardarCarga(request);
    }


    @PutMapping
    public AcademicChargeDto actualizarCarga(@RequestBody AcademicChargeDto request){
        return service.guardarCarga(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarCarga(@PathVariable("id") Long id){
        service.eliminarCarga(id);
    }

}
