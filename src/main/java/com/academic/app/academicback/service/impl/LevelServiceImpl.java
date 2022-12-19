package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.GradeDto;
import com.academic.app.academicback.dto.LevelDto;
import com.academic.app.academicback.entity.GradeEntity;
import com.academic.app.academicback.entity.LevelEntity;
import com.academic.app.academicback.repository.GradeRepository;
import com.academic.app.academicback.repository.LevelRepository;
import com.academic.app.academicback.service.GradeService;
import com.academic.app.academicback.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelRepository respository;

    public List<LevelDto> listarNivel(){
        List<LevelEntity> listaNivelEntity =respository.findAll();

        List<LevelDto> listaNivelDTO = new ArrayList<>();

        for (LevelEntity nivelEntity : listaNivelEntity){
            LevelDto nivelDTO = new LevelDto();
            nivelDTO.setId(nivelEntity.getId());
            nivelDTO.setNombre(nivelEntity.getName());
            nivelDTO.setDescripcion(nivelEntity.getDescription());
            //------------ Prueba para agregar persona al curso (demo)---------------------------
            //Optional<PersonEntity>persona = personRepository.findById(1);
            //cursoDTO.setNombrePersona(persona.get().getName());
            listaNivelDTO.add(nivelDTO);
        }

        return listaNivelDTO;
    }

    @Override
    public LevelDto obtenerNivelPorId(Long id) {
        Optional<LevelEntity> nivelEntity =respository.findById(id);
        LevelDto nivelDTO = new LevelDto();
        if(nivelEntity.isPresent()){
            nivelDTO.setId(nivelEntity.get().getId());
            nivelDTO.setNombre(nivelEntity.get().getName());
        }else {
            return new LevelDto();
        }
        return nivelDTO;
    }

    @Override
    public LevelDto guardarNivel(LevelDto request) {
                /*Insertar datos*/
        LevelEntity nivelEntity = new LevelEntity();
        nivelEntity.setId(request.getId());
        nivelEntity.setName(request.getNombre());
        nivelEntity.setDescription(request.getDescripcion());

        LevelEntity nivelGuardado=respository.save(nivelEntity);
                /*Mostrar datos*/
        LevelDto nivelDto = new LevelDto();
        nivelDto.setNombre(nivelGuardado.getName());
        nivelDto.setDescripcion(nivelGuardado.getDescription());


        return nivelDto;
    }

    @Override
    public void eliminarNivel(Long id) {
        respository.deleteById(id);
    }


}
