package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.CourseDto;
import com.academic.app.academicback.dto.PersonRelationDto;
import com.academic.app.academicback.entity.PersonRelationEntity;
import com.academic.app.academicback.entity.RelationshipEntity;
import com.academic.app.academicback.repository.PersonRelationshipRepository;
import com.academic.app.academicback.repository.RelationshipRepository;
import com.academic.app.academicback.service.PersonRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personrelationship")
public class PersonRelationshipController {
    @Autowired
    private PersonRelationService service;

    @GetMapping
    public List<PersonRelationDto.Response> listarPersParentesco(){
        return service.listarPersParentesco();
    }

    @GetMapping("/{id}")
    public PersonRelationDto.Response obtenerPersParentescoPorId(@PathVariable("id") Long id){
        return service.obtenerPersParentescoPorId(id);
    }

    @PostMapping
    public PersonRelationDto.Response guardarPersParentesco(@RequestBody PersonRelationDto.Request request){
        return service.guardarPersParentesco(request);
    }


    @PutMapping
    public PersonRelationDto.Response actualizarPersParentesco(@RequestBody PersonRelationDto.Request request){
        return service.guardarPersParentesco(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarPersParentesco(@PathVariable("id") Long id){
        service.eliminarPersParentesco(id);

    }

}
