package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.AcademicPlanDto;
import com.academic.app.academicback.entity.AcademicPlanEntity;
import com.academic.app.academicback.repository.AcademicPlanRepository;
import com.academic.app.academicback.service.AcademicPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AcademicPlanServiceImpl implements AcademicPlanService {

    @Autowired
    private AcademicPlanRepository respository;

    public List<AcademicPlanDto> listarPlan(){
        List<AcademicPlanEntity> listaPlanEntity =respository.findAll();

        List<AcademicPlanDto> listaPlanDTO = new ArrayList<>();

        for (AcademicPlanEntity planEntity : listaPlanEntity){
            AcademicPlanDto planDTO = new AcademicPlanDto();
            planDTO.setId(planEntity.getId());
            planDTO.setNombre(planEntity.getName());
            //------------ Prueba para agregar persona al curso (demo)---------------------------
            //Optional<PersonEntity>persona = personRepository.findById(1);
            //cursoDTO.setNombrePersona(persona.get().getName());
            listaPlanDTO.add(planDTO);
        }

        return listaPlanDTO;
    }

    @Override
    public AcademicPlanDto obtenerPlanPorId(Long id) {
        Optional<AcademicPlanEntity> planEntity =respository.findById(id);
        AcademicPlanDto planDTO = new AcademicPlanDto();
        if(planEntity.isPresent()){
            planDTO.setId(planEntity.get().getId());
            planDTO.setNombre(planEntity.get().getName());
        }else {
            return new AcademicPlanDto();
        }
        return planDTO;
    }

    @Override
    public AcademicPlanDto guardarPlan(AcademicPlanDto request) {
                /*Insertar datos*/
        AcademicPlanEntity planEntity = new AcademicPlanEntity();
        planEntity.setId(request.getId());
        planEntity.setName(request.getNombre());

        AcademicPlanEntity planGuardado=respository.save(planEntity);
                /*Mostrar datos*/
        AcademicPlanDto planDto = new AcademicPlanDto();
        planDto.setNombre(planGuardado.getName());

        return planDto;
    }

    @Override
    public void eliminarPlan(Long id) {
        respository.deleteById(id);
    }


}
