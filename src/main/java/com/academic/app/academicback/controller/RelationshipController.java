package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.PersonDto;
import com.academic.app.academicback.dto.RelationShipDto;
import com.academic.app.academicback.entity.GradeEntity;
import com.academic.app.academicback.entity.RelationshipEntity;
import com.academic.app.academicback.repository.GradeRepository;
import com.academic.app.academicback.repository.RelationshipRepository;
import com.academic.app.academicback.service.RelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/relationship")
public class RelationshipController {
    @Autowired
    private RelationShipService service;

    @GetMapping
    public List<RelationShipDto> listarParentesco(){
        return service.listarParentesco();
    }

    @GetMapping("/{id}")
    public RelationShipDto listarParentescoPorId(@PathVariable("id") Long id){
        return service.obtenerParentescoPorId(id);
    }

    @PostMapping
    public RelationShipDto guardarParentesco(@RequestBody RelationShipDto request){
        return service.guardarParentesco(request);
    }


    @PutMapping
    public RelationShipDto actualizarParentesco(@RequestBody RelationShipDto request){
        return service.guardarParentesco(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarParentesco(@PathVariable("id") Long id){
        service.eliminarParentesco(id);
    }

}
