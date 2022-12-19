package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.PeriodDto;
import com.academic.app.academicback.dto.PersonDto;
import com.academic.app.academicback.dto.SubPeriodDto;
import com.academic.app.academicback.entity.PeriodEntity;
import com.academic.app.academicback.entity.StudentEntity;
import com.academic.app.academicback.entity.SubPeriodEntity;
import com.academic.app.academicback.repository.PeriodRepository;
import com.academic.app.academicback.repository.SubPeriodRepository;
import com.academic.app.academicback.service.SubPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubPeriodServiceImpl implements SubPeriodService {

    @Autowired
    private SubPeriodRepository respository;

    @Autowired
    private PeriodRepository periodoRepository;

    public List<SubPeriodDto.Response> listarSubPeriodo(){
        List<SubPeriodEntity> listaSubPeriodoEntity =respository.findAll();

        List<SubPeriodDto.Response> listaSubPeriodoDTO = new ArrayList<>();

        for (SubPeriodEntity subperiodoEntity : listaSubPeriodoEntity){
            SubPeriodDto.Response subperiodoDto = new SubPeriodDto.Response();
            subperiodoDto.setId(subperiodoEntity.getId());
            subperiodoDto.setNombre(subperiodoEntity.getName());
            subperiodoDto.setTipo(subperiodoEntity.getType());

            Optional<PeriodEntity> periodo = periodoRepository.findById(subperiodoEntity.getPeriod().getId());
            PeriodDto periodoDto = new PeriodDto();
            periodoDto.setName(periodo.get().getName());
            subperiodoDto.setPeriodo(periodoDto);

            listaSubPeriodoDTO.add(subperiodoDto);
        }

        return listaSubPeriodoDTO;
    }

    @Override
    public SubPeriodDto.Response obtenerSubPeriodoPorId(Long id) {
        Optional<SubPeriodEntity> subperiodoEntity =respository.findById(id);
        SubPeriodDto.Response subperiodoDTO = new SubPeriodDto.Response();
        if(subperiodoEntity.isPresent()){
            subperiodoDTO.setId(subperiodoEntity.get().getId());
            subperiodoDTO.setNombre(subperiodoEntity.get().getName());

            Optional<PeriodEntity> periodo = periodoRepository.findById(subperiodoEntity.get().getPeriod().getId());
            PeriodDto periododto = new PeriodDto();
            periododto.setName(periodo.get().getName());
            subperiodoDTO.setPeriodo(periododto);
        }else {
            return new SubPeriodDto.Response();
        }
        return subperiodoDTO;
    }

    @Override
    public SubPeriodDto.Response guardarSubPeriodo(SubPeriodDto.Request request) {
                /*Insertar datos*/
        SubPeriodEntity subperiodoEntity = new SubPeriodEntity();
        subperiodoEntity.setId(request.getId());
        subperiodoEntity.setName(request.getNombre());
        subperiodoEntity.setType(request.getTipo());
        subperiodoEntity.setCondition(request.getEstado());

        PeriodEntity periodEntity = new PeriodEntity();
        periodEntity.setId(request.getId_periodo());

        subperiodoEntity.setPeriod(periodEntity);

        SubPeriodEntity subperiodoGuardado=respository.save(subperiodoEntity);
                /*Mostrar datos*/
        SubPeriodDto.Response subperiodoDto = new SubPeriodDto.Response();
        subperiodoDto.setNombre(subperiodoGuardado.getName());
        subperiodoDto.setTipo(subperiodoGuardado.getType());

        Optional<PeriodEntity> periodo = periodoRepository.findById(subperiodoGuardado.getPeriod().getId());
        PeriodDto periodoDto = new PeriodDto();
        periodoDto.setName(periodo.get().getName());
        subperiodoDto.setPeriodo(periodoDto);


        return subperiodoDto;
    }

    @Override
    public void eliminarSubPeriodo(Long id) {
        respository.deleteById(id);
    }


}
