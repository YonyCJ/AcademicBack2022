package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.EvaluationDto;
import com.academic.app.academicback.entity.AcademicChargeDetailEntity;
import com.academic.app.academicback.entity.EvaluationEntity;
import com.academic.app.academicback.repository.AcademicChargeDetailRepository;
import com.academic.app.academicback.repository.EvaluationRepository;
import com.academic.app.academicback.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepository respository;

    @Autowired
    private AcademicChargeDetailRepository cargaDetalleRepository;

    public List<EvaluationDto> listarEvaluacion(){
        List<EvaluationEntity> listaEvaluacionEntity =respository.findAll();

        List<EvaluationDto> listaEvaluacionDTO = new ArrayList<>();

        for (EvaluationEntity evaluacionEntity : listaEvaluacionEntity){
            EvaluationDto evaluacionDTO = new EvaluationDto();
            evaluacionDTO.setId(evaluacionEntity.getId());
            evaluacionDTO.setNombre(evaluacionEntity.getName());
            //------------ Prueba para agregar persona al curso (demo)---------------------------
            //Optional<PersonEntity>persona = personRepository.findById(1);
            //cursoDTO.setNombrePersona(persona.get().getName());
            listaEvaluacionDTO.add(evaluacionDTO);
        }

        return listaEvaluacionDTO;
    }

    @Override
    public EvaluationDto obtenerEvaluacionPorId(Long id) {
        Optional<EvaluationEntity> evaluacionEntity =respository.findById(id);
        EvaluationDto evaluacionDTO = new EvaluationDto();
        if(evaluacionEntity.isPresent()){
            evaluacionDTO.setId(evaluacionEntity.get().getId());
            evaluacionDTO.setNombre(evaluacionEntity.get().getName());
        }else {
            return new EvaluationDto();
        }
        return evaluacionDTO;
    }

    @Override
    public EvaluationDto guardarEvaluacion(EvaluationDto request) {
                /*Insertar datos*/
        EvaluationEntity evaluacionEntity = new EvaluationEntity();
        evaluacionEntity.setId(request.getId());
        evaluacionEntity.setName(request.getNombre());
        evaluacionEntity.setPercentage(request.getPorcentaje());
        evaluacionEntity.setNumberOrder(request.getNumeroOrden());
        evaluacionEntity.setCondition(request.getEstado());

        AcademicChargeDetailEntity cargaDetalleEntity = new AcademicChargeDetailEntity();
        cargaDetalleEntity.setId(request.getId_carga_academica_detalle());

        evaluacionEntity.setAcademicChargeDetail(cargaDetalleEntity);
        EvaluationEntity evaluacionGuardada=respository.save(evaluacionEntity);
                /*Mostrar datos*/
        EvaluationDto evaluacionDto = new EvaluationDto();
        evaluacionDto.setNombre(evaluacionGuardada.getName());
        evaluacionDto.setPorcentaje(evaluacionGuardada.getPercentage());
        evaluacionDto.setNumeroOrden(evaluacionGuardada.getNumberOrder());
        evaluacionDto.setEstado(evaluacionGuardada.getCondition());


        return evaluacionDto;
    }

    @Override
    public void eliminarEvaluacion(Long id) {
        respository.deleteById(id);
    }


}
