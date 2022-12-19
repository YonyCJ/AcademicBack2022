package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.GradeDto;
import com.academic.app.academicback.entity.GradeEntity;
import com.academic.app.academicback.entity.LevelEntity;
import com.academic.app.academicback.repository.GradeRepository;
import com.academic.app.academicback.repository.LevelRepository;
import com.academic.app.academicback.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository respository;

    @Autowired
    private LevelRepository levelRepository;

    public List<GradeDto> listarGrado(){
        List<GradeEntity> listaGradoEntity =respository.findAll();

        List<GradeDto> listaGradoDTO = new ArrayList<>();

        for (GradeEntity gradoEntity : listaGradoEntity){
            GradeDto gradoDTO = new GradeDto();
            gradoDTO.setId(gradoEntity.getId());
            gradoDTO.setNombre(gradoEntity.getName());
            //------------ Prueba para agregar persona al curso (demo)---------------------------
            //Optional<PersonEntity>persona = personRepository.findById(1);
            //cursoDTO.setNombrePersona(persona.get().getName());
            listaGradoDTO.add(gradoDTO);
        }

        return listaGradoDTO;
    }

    @Override
    public GradeDto obtenerGradoPorId(Long id) {
        Optional<GradeEntity> gradoEntity =respository.findById(id);
        GradeDto gradoDTO = new GradeDto();
        if(gradoEntity.isPresent()){
            gradoDTO.setId(gradoEntity.get().getId());
            gradoDTO.setNombre(gradoEntity.get().getName());
        }else {
            return new GradeDto();
        }
        return gradoDTO;
    }

    @Override
    public GradeDto guardarGrado(GradeDto request) {
                /*Insertar datos*/
        GradeEntity gradoEntity = new GradeEntity();
        gradoEntity.setId(request.getId());
        gradoEntity.setName(request.getNombre());
        gradoEntity.setDescription(request.getDescripcion());

        LevelEntity nivelEntity = new LevelEntity();
        nivelEntity.setId(request.getId_nivel());

        gradoEntity.setLevel(nivelEntity);
        GradeEntity gradoGuardado=respository.save(gradoEntity);
                /*Mostrar datos*/
        GradeDto gradeDto = new GradeDto();
        gradeDto.setNombre(gradoGuardado.getName());
        gradeDto.setDescripcion(gradoGuardado.getDescription());


        return gradeDto;
    }

    @Override
    public void eliminarGrado(Long id) {
        respository.deleteById(id);
    }


}
