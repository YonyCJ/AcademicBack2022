package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.PersonDto;
import com.academic.app.academicback.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping
    public List<PersonDto> listarCursos(){
        return service.listarPersonas();
    }

    @GetMapping("/{id}")
    public PersonDto listarPersonPorId(@PathVariable("id") Long id){

        return service.obtenerPersonaPorId(id);
    }

    @PostMapping
    public PersonDto guardarPerson(@RequestBody PersonDto request){
        return service.guardarPersona(request);
    }

    @PutMapping
    public PersonDto actualizarPerson(@RequestBody PersonDto request){
        return service.guardarPersona(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable("id") Long id){
        service.eliminarPersona(id);

    }

}
