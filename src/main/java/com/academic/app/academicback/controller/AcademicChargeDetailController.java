package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.AcademicChargeDetailDto;
import com.academic.app.academicback.service.AcademicChargeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chargeDetail")
public class AcademicChargeDetailController {
    @Autowired
    private AcademicChargeDetailService service;

    @GetMapping
    public List<AcademicChargeDetailDto> listarCargaDetalle(){
        return service.listarCargaDetalle();
    }

    @GetMapping("/{id}")
    public AcademicChargeDetailDto listarCargaDetallePorId(@PathVariable("id") Long id){
        return service.obtenerCargaDetallePorId(id);
    }

    @PostMapping
    public AcademicChargeDetailDto guardarCargaDetalle(@RequestBody AcademicChargeDetailDto request){
        return service.guardarCargaDetalle(request);
    }


    @PutMapping
    public AcademicChargeDetailDto actualizarCargaDetalle(@RequestBody AcademicChargeDetailDto request){
        return service.guardarCargaDetalle(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarCargaDetalle(@PathVariable("id") Long id){
        service.eliminarCargaDetalle(id);
    }

}
