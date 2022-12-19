package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.AcademicChargeDto;
import com.academic.app.academicback.dto.CourseDto;
import com.academic.app.academicback.entity.*;
import com.academic.app.academicback.repository.*;
import com.academic.app.academicback.service.AcademicChargeService;
import com.academic.app.academicback.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AcademicChargeServiceImpl implements AcademicChargeService {

    @Autowired
    private AcademicChargeRepository respository;

    @Autowired
    private PeriodRepository periodRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private AcademicPlanRepository planRepository;

    public List<AcademicChargeDto> listarCarga(){
        List<AcademicChargeEntity> listaCargaEntity =respository.findAll();

        List<AcademicChargeDto> listaCargaDTO = new ArrayList<>();

        for (AcademicChargeEntity cargaEntity : listaCargaEntity){
            AcademicChargeDto cargaDTO = new AcademicChargeDto();
            cargaDTO.setId(cargaEntity.getId());
            cargaDTO.setNombre(cargaEntity.getName());
            cargaDTO.setDescripcion(cargaEntity.getDescription());

            //------------ Prueba para agregar persona al curso (demo)---------------------------
            //Optional<PersonEntity>persona = personRepository.findById(1);
            //cursoDTO.setNombrePersona(persona.get().getName());
            listaCargaDTO.add(cargaDTO);
        }

        return listaCargaDTO;
    }

    @Override
    public AcademicChargeDto obtenerCargaPorId(Long id) {
        Optional<AcademicChargeEntity> cargaEntity =respository.findById(id);
        AcademicChargeDto cargaDTO = new AcademicChargeDto();
        if(cargaEntity.isPresent()){
            cargaDTO.setId(cargaEntity.get().getId());
            cargaDTO.setNombre(cargaEntity.get().getName());
            cargaDTO.setDescripcion(cargaEntity.get().getDescription());
        }else {
            return new AcademicChargeDto();
        }
        return cargaDTO;
    }

    @Override
    public AcademicChargeDto guardarCarga(AcademicChargeDto request) {
                /*Insertar datos*/
        AcademicChargeEntity cargaEntity = new AcademicChargeEntity();
        cargaEntity.setId(request.getId());
        cargaEntity.setName(request.getNombre());
        cargaEntity.setDescription(request.getDescripcion());
        cargaEntity.setCondition(request.getEstado());

        PeriodEntity periodoEntity = new PeriodEntity();
        periodoEntity.setId(request.getId_periodo());

        SectionEntity seccionEntity = new SectionEntity();
        seccionEntity.setId(request.getId_seccion());

        GradeEntity gradoEntity = new GradeEntity();
        gradoEntity.setId(request.getId_grado());

        LevelEntity nivelEntity = new LevelEntity();
        nivelEntity.setId(request.getId_nivel());

        AcademicPlanEntity planacademicoEntity = new AcademicPlanEntity();
        planacademicoEntity.setId(request.getId_plan_academico());

        cargaEntity.setPeriod(periodoEntity);
        cargaEntity.setSection(seccionEntity);
        cargaEntity.setGrade(gradoEntity);
        cargaEntity.setLevel(nivelEntity);
        cargaEntity.setAcademicPlan(planacademicoEntity);
        AcademicChargeEntity cargaGuardada=respository.save(cargaEntity);
                /*Mostrar datos*/
        AcademicChargeDto cargaDto = new AcademicChargeDto();
        cargaDto.setNombre(cargaGuardada.getName());
        cargaDto.setDescripcion(cargaGuardada.getDescription());


        return cargaDto;
    }

    @Override
    public void eliminarCarga(Long id) {
        respository.deleteById(id);
    }


}
