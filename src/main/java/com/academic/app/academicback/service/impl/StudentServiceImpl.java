package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.PersonDto;
import com.academic.app.academicback.dto.StudentDto;
import com.academic.app.academicback.entity.PersonEntity;
import com.academic.app.academicback.entity.StudentEntity;
import com.academic.app.academicback.repository.PersonRepository;
import com.academic.app.academicback.repository.StudentRepository;
import com.academic.app.academicback.service.PersonService;
import com.academic.app.academicback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository respository;

    public List<StudentDto> listarAlumnos(){
        List<StudentEntity> listaAlumnoEntity =respository.findAll();

        List<StudentDto> listaAlumnoDTO = new ArrayList<>();

        for (StudentEntity alumnoEntity : listaAlumnoEntity){
            StudentDto alumnoDto = new StudentDto();
            alumnoDto.setId(alumnoEntity.getId());
            alumnoDto.setCodigo(alumnoEntity.getCode());

            listaAlumnoDTO.add(alumnoDto);
        }

        return listaAlumnoDTO;
    }

    @Override
    public StudentDto obtenerAlumnoPorId(Long id) {
        Optional<StudentEntity> alumnoEntity =respository.findById(id);
        StudentDto alumnoDTO = new StudentDto();
        if(alumnoEntity.isPresent()){
            alumnoDTO.setId(alumnoEntity.get().getId());
//            PersonEntity personEntity = new PersonEntity();
//            personEntity.setId(request.getId_persona());
            alumnoDTO.setCodigo(alumnoEntity.get().getCode());

//            alumnoDTO.setId(alumnoDTO.getId());
        }else {
            return new StudentDto();
        }
        return alumnoDTO;
    }

    @Override
    public StudentDto guardarAlumno(StudentDto request) {
                /*Insertar datos*/
        StudentEntity alumnoEntity = new StudentEntity();
        alumnoEntity.setId(request.getId());
        alumnoEntity.setCode(request.getCodigo());

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(request.getId_persona());

        alumnoEntity.setPerson(personEntity);

        StudentEntity alumnoGuardado=respository.save(alumnoEntity);
                /*Mostrar datos*/
        StudentDto alumnoDto = new StudentDto();
        alumnoDto.setCodigo(alumnoGuardado.getCode());

        return alumnoDto;
    }

    @Override
    public void eliminarAlumno(Long id) {
        respository.deleteById(id);
    }


}
