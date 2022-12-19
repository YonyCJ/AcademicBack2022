package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.PeriodDto;
import com.academic.app.academicback.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/period")
public class PeriodController {
    @Autowired
    private PeriodService service;

    @GetMapping
    public List<PeriodDto> listarPeriodo(){
        return service.listarPeriodo();
    }

    @GetMapping("/{id}")
    public PeriodDto listarPeriodoPorId(@PathVariable("id") Long id){
        return service.obtenerPeriodoPorId(id);
    }

    @PostMapping
    public PeriodDto guardarPeriodo(@RequestBody PeriodDto request){
        return service.guardarPeriodo(request);
    }


    @PutMapping
    public PeriodDto actualizarPeriodo(@RequestBody PeriodDto request){
        return service.guardarPeriodo(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarPeriodo(@PathVariable("id") Long id){
        service.eliminarPeriodo(id);
    }

}
