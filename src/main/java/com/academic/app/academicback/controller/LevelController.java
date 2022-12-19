package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.LevelDto;
import com.academic.app.academicback.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/level")
public class LevelController {
    @Autowired
    private LevelService service;

    @GetMapping
    public List<LevelDto> listarNivel(){
        return service.listarNivel();
    }

    @GetMapping("/{id}")
    public LevelDto listarNivelPorId(@PathVariable("id") Long id){
        return service.obtenerNivelPorId(id);
    }

    @PostMapping
    public LevelDto guardarNivel(@RequestBody LevelDto request){
        return service.guardarNivel(request);
    }


    @PutMapping
    public LevelDto actualizarNivel(@RequestBody LevelDto request){
        return service.guardarNivel(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarNivel(@PathVariable("id") Long id){
        service.eliminarNivel(id);
    }

}
