package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.CourseDto;
import com.academic.app.academicback.entity.AcademicPlanEntity;
import com.academic.app.academicback.entity.CourseEntity;
import com.academic.app.academicback.repository.CourseRepository;
import com.academic.app.academicback.repository.PersonRepository;
import com.academic.app.academicback.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private PersonRepository personRepository;

    public List<CourseDto> listarCursos(){
        List<CourseEntity> listaCursosEntity =repository.findAll();

        List<CourseDto> listaCursosDTO = new ArrayList<>();

        for (CourseEntity cursoEntity : listaCursosEntity){
            CourseDto cursoDTO = new CourseDto();
            cursoDTO.setId(cursoEntity.getId());
            cursoDTO.setName(cursoEntity.getName());
            //------------ Prueba para agregar persona al curso (demo)---------------------------
            //Optional<PersonEntity>persona = personRepository.findById(1);
            //cursoDTO.setNombrePersona(persona.get().getName());
            listaCursosDTO.add(cursoDTO);
        }

        return listaCursosDTO;
    }

    @Override
    public CourseDto obtenerCursoPorId(Long id) {
        Optional<CourseEntity> cursoEntity =repository.findById(id);
        CourseDto cursoDTO = new CourseDto();
        if(cursoEntity.isPresent()){
            cursoDTO.setId(cursoEntity.get().getId());
            cursoDTO.setName(cursoEntity.get().getName());
        }else {
            return new CourseDto();
        }
        return cursoDTO;
    }

    @Override
    public CourseDto guardarCurso(CourseDto request) {
                /*Insertar datos*/
        CourseEntity cursoEntity = new CourseEntity();
        cursoEntity.setId(request.getId());
        cursoEntity.setName(request.getName());

        AcademicPlanEntity academicPlanEntity = new AcademicPlanEntity();
        academicPlanEntity.setId(request.getAcademicPlanId());

        cursoEntity.setAcademicPlan(academicPlanEntity);
        CourseEntity cursoGuardado=repository.save(cursoEntity);
                /*Mostrar datos*/
        CourseDto cursoDto = new CourseDto();
        cursoDto.setName(cursoGuardado.getName());

        return cursoDto;
    }

    @Override
    public void eliminarCurso(Long id) {
        repository.deleteById(id);
    }


}
