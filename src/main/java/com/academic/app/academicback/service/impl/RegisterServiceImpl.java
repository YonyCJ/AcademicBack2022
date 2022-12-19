package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.*;
import com.academic.app.academicback.entity.*;
import com.academic.app.academicback.repository.*;
import com.academic.app.academicback.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository repository;

    @Autowired
    private StudentRepository alumnoRespository;
    @Autowired
    private AcademicChargeRepository cargaRespository;
    @Autowired
    private PeriodRepository periodoRespository;
    @Autowired
    private GradeRepository gradoRespository;
    @Autowired
    private SectionRepository seccionRespository;
    @Autowired
    private LevelRepository nivelRespository;


    public List<RegisterDto.Response> listarMatricula(){
        List<RegisterEntity> listaMatriculaEntity =repository.findAll();

        List<RegisterDto.Response> listaMatriculaDTO = new ArrayList<>();

        for (RegisterEntity matriculaEntity : listaMatriculaEntity){
            RegisterDto.Response matriculaDTO = new RegisterDto.Response();
            matriculaDTO.setId(matriculaEntity.getId());

            Optional<StudentEntity> alumno = alumnoRespository.findById(matriculaEntity.getStudent().getId());
            PersonDto person = new PersonDto();
            person.setName(alumno.get().getPerson().getName());
            person.setApellido_paterno(alumno.get().getPerson().getLastName());
            matriculaDTO.setPersona(person);

            Optional<AcademicChargeEntity> carga = cargaRespository.findById(matriculaEntity.getAcademicCharge().getId());
            AcademicChargeDto cargaAcademica = new AcademicChargeDto();
            cargaAcademica.setNombre(carga.get().getName());
            matriculaDTO.setCarga(cargaAcademica);

            Optional<PeriodEntity> periodo = periodoRespository.findById(matriculaEntity.getPeriod().getId());
            PeriodDto periododto = new PeriodDto();
            periododto.setName(periodo.get().getName());
            matriculaDTO.setPeriodo(periododto);

            Optional<GradeEntity> grado = gradoRespository.findById(matriculaEntity.getGrade().getId());
            GradeDto gradodto = new GradeDto();
            gradodto.setNombre(grado.get().getName());
            matriculaDTO.setGrado(gradodto);

            Optional<SectionEntity> seccion = seccionRespository.findById(matriculaEntity.getSection().getId());
            SectionDto secciondto = new SectionDto();
            secciondto.setNombre(seccion.get().getName());
            matriculaDTO.setSeccion(secciondto);

            Optional<LevelEntity> nivel = nivelRespository.findById(matriculaEntity.getLevel().getId());
            LevelDto niveldto = new LevelDto();
            niveldto.setNombre(nivel.get().getName());
            matriculaDTO.setNivel(niveldto);


            listaMatriculaDTO.add(matriculaDTO);
        }

        return listaMatriculaDTO;
    }

    @Override
    public RegisterDto.Response obtenerMatriculaPorId(Long id) {

        RegisterDto.Response matriculaDTO = new RegisterDto.Response();

        Optional<RegisterEntity> matriculaEntity =repository.findById(id);

        if(matriculaEntity.isPresent()){
            matriculaDTO.setId(matriculaEntity.get().getId());

            Optional<StudentEntity> alumno = alumnoRespository.findById(matriculaEntity.get().getStudent().getId());
            PersonDto person = new PersonDto();
            person.setName(alumno.get().getPerson().getName());
            person.setApellido_paterno(alumno.get().getPerson().getLastName());
            matriculaDTO.setPersona(person);

            Optional<AcademicChargeEntity> carga = cargaRespository.findById(matriculaEntity.get().getAcademicCharge().getId());
            AcademicChargeDto cargaAcademica = new AcademicChargeDto();
            cargaAcademica.setNombre(carga.get().getName());
            matriculaDTO.setCarga(cargaAcademica);

            Optional<PeriodEntity> periodo = periodoRespository.findById(matriculaEntity.get().getPeriod().getId());
            PeriodDto periododto = new PeriodDto();
            periododto.setName(periodo.get().getName());
            matriculaDTO.setPeriodo(periododto);

            Optional<GradeEntity> grado = gradoRespository.findById(matriculaEntity.get().getGrade().getId());
            GradeDto gradodto = new GradeDto();
            gradodto.setNombre(grado.get().getName());
            matriculaDTO.setGrado(gradodto);

            Optional<SectionEntity> seccion = seccionRespository.findById(matriculaEntity.get().getSection().getId());
            SectionDto secciondto = new SectionDto();
            secciondto.setNombre(seccion.get().getName());
            matriculaDTO.setSeccion(secciondto);

            Optional<LevelEntity> nivel = nivelRespository.findById(matriculaEntity.get().getLevel().getId());
            LevelDto niveldto = new LevelDto();
            niveldto.setNombre(nivel.get().getName());
            matriculaDTO.setNivel(niveldto);

        }else {
            return new RegisterDto.Response();
        }
        return matriculaDTO;
    }
    @Override
    @Transactional
    public RegisterDto.Response guardarMatricula(RegisterDto.Request request) {
                //*Insertar datos*//*
        RegisterEntity matriculaEntity = new RegisterEntity();
        matriculaEntity.setId(request.getId());


        StudentEntity alumnoEntity = new StudentEntity();
        alumnoEntity.setId(request.getIdAlumno());

        AcademicChargeEntity cargaEntity = new AcademicChargeEntity();
        cargaEntity.setId(request.getIdCargaCcademica());

        PeriodEntity periodoEntity = new PeriodEntity();
        periodoEntity.setId(request.getIdPeriodo());

        GradeEntity gradoEntity = new GradeEntity();
        gradoEntity.setId(request.getIdGrado());

        SectionEntity seccionEntity = new SectionEntity();
        seccionEntity.setId(request.getIdSeccion());

        LevelEntity nivelEntity = new LevelEntity();
        nivelEntity.setId(request.getIdNivel());

        matriculaEntity.setStudent(alumnoEntity);
        matriculaEntity.setAcademicCharge(cargaEntity);
        matriculaEntity.setPeriod(periodoEntity);
        matriculaEntity.setGrade(gradoEntity);
        matriculaEntity.setSection(seccionEntity);
        matriculaEntity.setLevel(nivelEntity);
        RegisterEntity matriculaGuardada=repository.save(matriculaEntity);
                //*Mostrar datos*//*
        RegisterDto.Response matriculaDto = new  RegisterDto.Response();
        matriculaDto.setId(matriculaGuardada.getId());

        Optional<StudentEntity> alumno = alumnoRespository.findById(matriculaGuardada.getStudent().getId());
        PersonDto person = new PersonDto();
        person.setName(alumno.get().getPerson().getName());
        person.setApellido_paterno(alumno.get().getPerson().getLastName());
        matriculaDto.setPersona(person);



        return matriculaDto;
    }

    @Override
    public void eliminarMatricula(Long id) {
        repository.deleteById(id);
    }


}
