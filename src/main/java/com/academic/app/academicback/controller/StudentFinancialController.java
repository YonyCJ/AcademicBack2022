package com.academic.app.academicback.controller;

import com.academic.app.academicback.dto.StudentDto;
import com.academic.app.academicback.dto.StudentFinancialDto;
import com.academic.app.academicback.service.StudentFinancialService;
import com.academic.app.academicback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studentFinancial")
public class StudentFinancialController {
    @Autowired
    private StudentFinancialService service;

    @GetMapping
    public List<StudentFinancialDto.Response> listarFinanciero(){
        return service.listarFinanciero();
    }

    @GetMapping("/{id}")
    public StudentFinancialDto.Response obtenerFinancieroPorId(@PathVariable("id") Long id){

        return service.obtenerFinancieroPorId(id);
    }

    @PostMapping
    public StudentFinancialDto.Response guardarFinanciero(@RequestBody StudentFinancialDto.Request request){
        return service.guardarFinanciero(request);
    }


    @PutMapping
    public StudentFinancialDto.Response actualizarAlumno(@RequestBody StudentFinancialDto.Request request){
        return service.guardarFinanciero(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarFinanciero(@PathVariable("id") Long id){
        service.eliminarFinanciero(id);

    }

}
