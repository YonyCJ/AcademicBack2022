package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.CourseDto;
import com.academic.app.academicback.dto.RegisterDto;
import com.academic.app.academicback.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    private RegisterService service;

    @GetMapping
    public List<RegisterDto.Response> listarMatricula(){
        return service.listarMatricula();
    }

    @GetMapping("/{id}")
    public RegisterDto.Response listarMatriculaPorId(@PathVariable("id") Long id){

        return service.obtenerMatriculaPorId(id);
    }

    @PostMapping
    public RegisterDto.Response guardarMatricula(@RequestBody RegisterDto.Request request){
        return service.guardarMatricula(request);
    }


    @PutMapping
    public RegisterDto.Response actualizarMatricula(@RequestBody RegisterDto.Request request){
        return service.guardarMatricula(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarMatricula(@PathVariable("id") Long id){
        service.eliminarMatricula(id);

    }


}
