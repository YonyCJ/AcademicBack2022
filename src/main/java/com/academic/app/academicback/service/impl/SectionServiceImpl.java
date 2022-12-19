package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.GradeDto;
import com.academic.app.academicback.dto.SectionDto;
import com.academic.app.academicback.entity.GradeEntity;
import com.academic.app.academicback.entity.LevelEntity;
import com.academic.app.academicback.entity.SectionEntity;
import com.academic.app.academicback.entity.TeacherEntity;
import com.academic.app.academicback.repository.GradeRepository;
import com.academic.app.academicback.repository.LevelRepository;
import com.academic.app.academicback.repository.SectionRepository;
import com.academic.app.academicback.repository.TeacherRepository;
import com.academic.app.academicback.service.GradeService;
import com.academic.app.academicback.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository respository;

    @Autowired
    private TeacherRepository tutorRepository;

    @Autowired
    private GradeRepository gradoRepository;

    public List<SectionDto> listarSeccion(){
        List<SectionEntity> listaSeccionEntity =respository.findAll();

        List<SectionDto> listaSeccionDTO = new ArrayList<>();

        for (SectionEntity seccionEntity : listaSeccionEntity){
            SectionDto sectionDto = new SectionDto();
            sectionDto.setId(seccionEntity.getId());
            sectionDto.setNombre(seccionEntity.getName());
            sectionDto.setDescripcion(seccionEntity.getDescription());
            //------------ Prueba para agregar persona al curso (demo)---------------------------
            //Optional<PersonEntity>persona = personRepository.findById(1);
            //cursoDTO.setNombrePersona(persona.get().getName());
            listaSeccionDTO.add(sectionDto);
        }

        return listaSeccionDTO;
    }

    @Override
    public SectionDto obtenerSeccionPorId(Long id) {
        Optional<SectionEntity> seccionEntity =respository.findById(id);
        SectionDto sectionDto = new SectionDto();
        if(seccionEntity.isPresent()){
            sectionDto.setId(seccionEntity.get().getId());
            sectionDto.setNombre(seccionEntity.get().getName());
        }else {
            return new SectionDto();
        }
        return sectionDto;
    }

    @Override
    public SectionDto guardarSeccion(SectionDto request) {
                /*Insertar datos*/
        SectionEntity seccionEntity = new SectionEntity();
        seccionEntity.setId(request.getId());
        seccionEntity.setName(request.getNombre());
        seccionEntity.setDescription(request.getDescripcion());

        TeacherEntity tutorEntity = new TeacherEntity();
        tutorEntity.setId(request.getId_docente());

        GradeEntity gradoEntity = new GradeEntity();
        gradoEntity.setId(request.getId_grado());

        seccionEntity.setTutor(tutorEntity);
        seccionEntity.setGrade(gradoEntity);

        SectionEntity seccionGuardada=respository.save(seccionEntity);
                /*Mostrar datos*/
        SectionDto seccionDto = new SectionDto();
        seccionDto.setNombre(seccionGuardada.getName());
        seccionDto.setDescripcion(seccionGuardada.getDescription());

        return seccionDto;
    }

    @Override
    public void eliminarSeccion(Long id) {
        respository.deleteById(id);
    }


}
