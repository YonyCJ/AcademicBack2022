package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.AcademicChargeDetailDto;
import com.academic.app.academicback.entity.*;
import com.academic.app.academicback.repository.*;
import com.academic.app.academicback.service.AcademicChargeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AcademicChargeDetailServiceImpl implements AcademicChargeDetailService {

    @Autowired
    private AcademicChargeDetailRepository respository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<AcademicChargeDetailDto> listarCargaDetalle(){
        List<AcademicChargeDetailEntity> listaCargaDetalleEntity =respository.findAll();

        List<AcademicChargeDetailDto> listaCargaDetalleDTO = new ArrayList<>();

        for (AcademicChargeDetailEntity cargaDetalleEntity : listaCargaDetalleEntity){
            AcademicChargeDetailDto cargaDetalleDTO = new AcademicChargeDetailDto();
            cargaDetalleDTO.setId(cargaDetalleEntity.getId());
            cargaDetalleDTO.setAula(cargaDetalleEntity.getClassroom());
            cargaDetalleDTO.setCupo(cargaDetalleEntity.getQuota());

            //------------ Prueba para agregar persona al curso (demo)---------------------------
            //Optional<PersonEntity>persona = personRepository.findById(1);
            //cursoDTO.setNombrePersona(persona.get().getName());
            listaCargaDetalleDTO.add(cargaDetalleDTO);
        }

        return listaCargaDetalleDTO;
    }

    @Override
    public AcademicChargeDetailDto obtenerCargaDetallePorId(Long id) {
        Optional<AcademicChargeDetailEntity> cargaDetalleEntity =respository.findById(id);
        AcademicChargeDetailDto cargaDetalleDTO = new AcademicChargeDetailDto();
        if(cargaDetalleEntity.isPresent()){
            cargaDetalleDTO.setId(cargaDetalleEntity.get().getId());
            cargaDetalleDTO.setDescripcion(cargaDetalleEntity.get().getDescription());
            cargaDetalleDTO.setAula(cargaDetalleEntity.get().getClassroom());
            cargaDetalleDTO.setCupo(cargaDetalleEntity.get().getQuota());
        }else {
            return new AcademicChargeDetailDto();
        }
        return cargaDetalleDTO;
    }

    @Override
    public AcademicChargeDetailDto guardarCargaDetalle(AcademicChargeDetailDto request) {
                /*Insertar datos*/
        AcademicChargeDetailEntity cargaDetalleEntity = new AcademicChargeDetailEntity();
        cargaDetalleEntity.setId(request.getId());
        cargaDetalleEntity.setDescription(request.getDescripcion());
        cargaDetalleEntity.setCondition(request.getEstado());
        cargaDetalleEntity.setClassroom(request.getAula());
        cargaDetalleEntity.setQuota(request.getCupo());

        CourseEntity cursoEntity = new CourseEntity();
        cursoEntity.setId(request.getId_curso());

        TeacherEntity docenteEntity = new TeacherEntity();
        docenteEntity.setId(request.getId_docente());


        cargaDetalleEntity.setCourse(cursoEntity);
        cargaDetalleEntity.setTeacher(docenteEntity);

        AcademicChargeDetailEntity cargaDetalleGuardada=respository.save(cargaDetalleEntity);
                /*Mostrar datos*/
        AcademicChargeDetailDto cargaDetalleDto = new AcademicChargeDetailDto();
        cargaDetalleDto.setDescripcion(cargaDetalleGuardada.getDescription());
        cargaDetalleDto.setEstado(cargaDetalleGuardada.getCondition());
        cargaDetalleDto.setAula(cargaDetalleGuardada.getClassroom());
        cargaDetalleDto.setCupo(cargaDetalleGuardada.getQuota());


        return cargaDetalleDto;
    }

    @Override
    public void eliminarCargaDetalle(Long id) {
        respository.deleteById(id);
    }


}
