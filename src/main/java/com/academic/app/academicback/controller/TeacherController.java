package com.academic.app.academicback.controller;

import com.academic.app.academicback.entity.LevelEntity;
import com.academic.app.academicback.entity.TeacherEntity;
import com.academic.app.academicback.repository.LevelRepository;
import com.academic.app.academicback.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherRepository respository;

    @GetMapping
    public List<TeacherEntity> listarDocentes(){
        return respository.findAll();
    }

    @GetMapping("/filtrar/{name}")
    public List<TeacherEntity> listarDocentes(@PathVariable("name") String name){
        return respository.findAllByPersonName(name);
    }

    @GetMapping("/{id}")
    public TeacherEntity listarDocentesPorId(@PathVariable("id") Long id){

        Optional<TeacherEntity> docente =respository.findById(id);
        if(docente.isPresent()){
            return docente.get();
        }else {
            return new TeacherEntity();
        }
    }

    @PostMapping
    public TeacherEntity guardarDocente(@RequestBody TeacherEntity data){
        return respository.save(data);
    }


    @PutMapping
    public TeacherEntity actualizarDocente(@RequestBody TeacherEntity data){
        return respository.save(data);
    }

    @DeleteMapping("/{id}")
    public List<TeacherEntity>  eliminarDocente(@PathVariable("id") Long id){
        respository.deleteById(id);
        return respository.findAll();
    }

}
