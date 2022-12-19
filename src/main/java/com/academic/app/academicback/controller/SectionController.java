package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.PersonDto;
import com.academic.app.academicback.dto.SectionDto;
import com.academic.app.academicback.entity.SectionEntity;
import com.academic.app.academicback.repository.SectionRepository;
import com.academic.app.academicback.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/section")
public class SectionController {
    @Autowired
    private SectionService service;

    @GetMapping
    public List<SectionDto> listarSeccion(){
        return service.listarSeccion();
    }

    @GetMapping("/{id}")
    public SectionDto listarSeccionPorId(@PathVariable("id") Long id){

        return service.obtenerSeccionPorId(id);
    }

    @PostMapping
    public SectionDto guardarSeccion(@RequestBody SectionDto request){
        return service.guardarSeccion(request);
    }


    @PutMapping
    public SectionDto actualizarSeccion(@RequestBody SectionDto request){
        return service.guardarSeccion(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarSeccion(@PathVariable("id") Long id){
        service.eliminarSeccion(id);

    }

}
