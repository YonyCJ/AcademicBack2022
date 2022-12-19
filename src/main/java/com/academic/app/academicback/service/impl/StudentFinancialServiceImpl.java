package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.*;
import com.academic.app.academicback.entity.*;
import com.academic.app.academicback.repository.RegisterRepository;
import com.academic.app.academicback.repository.StudentFinancialRepository;
import com.academic.app.academicback.repository.StudentRepository;
import com.academic.app.academicback.service.StudentFinancialService;
import com.academic.app.academicback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentFinancialServiceImpl implements StudentFinancialService {

    @Autowired
    private StudentFinancialRepository repository;
    @Autowired
    private StudentRepository alumnoRespository;
    @Autowired
    private RegisterRepository matriculaRespository;

    public List<StudentFinancialDto.Response> listarFinanciero(){
        List<StudentFinancialManagerEntity> listaFinancieroEntity =repository.findAll();

        List<StudentFinancialDto.Response> listaFinancialDTO = new ArrayList<>();

        for (StudentFinancialManagerEntity financialEntity : listaFinancieroEntity){
            StudentFinancialDto.Response financieroDto = new StudentFinancialDto.Response();
            financieroDto.setId(financialEntity.getId());

            Optional<StudentEntity> alumno = alumnoRespository.findById(financialEntity.getStudent().getId());
            PersonDto person = new PersonDto();
            person.setName(alumno.get().getPerson().getName());
            person.setApellido_paterno(alumno.get().getPerson().getLastName());
            financieroDto.setAlumno(person);

            Optional<RegisterEntity> matricula = matriculaRespository.findById(financialEntity.getRegister().getId());
            RegisterDto.Response matriculaDto = new RegisterDto.Response();
            matriculaDto.setId(matricula.get().getId());
            financieroDto.setMatricula(matriculaDto);

            listaFinancialDTO.add(financieroDto);
        }

        return listaFinancialDTO;
    }

    @Override
    public StudentFinancialDto.Response obtenerFinancieroPorId(Long id) {
        Optional<StudentFinancialManagerEntity> alumnoFinancieroEntity =repository.findById(id);
        StudentFinancialDto.Response alumnoFinandieroDTO = new StudentFinancialDto.Response();
        if(alumnoFinancieroEntity.isPresent()){
            alumnoFinandieroDTO.setId(alumnoFinancieroEntity.get().getId());

            Optional<StudentEntity> alumno = alumnoRespository.findById(alumnoFinancieroEntity.get().getStudent().getId());
            PersonDto person = new PersonDto();
            person.setName(alumno.get().getPerson().getName());
            person.setApellido_paterno(alumno.get().getPerson().getLastName());
            alumnoFinandieroDTO.setAlumno(person);

            Optional<RegisterEntity> matricula = matriculaRespository.findById(alumnoFinancieroEntity.get().getRegister().getId());
            RegisterDto.Response alumnoDto = new RegisterDto.Response();
            alumnoDto.setId(matricula.get().getId());
            alumnoFinandieroDTO.setMatricula(alumnoDto);

        }else {
            return new StudentFinancialDto.Response();
        }
        return alumnoFinandieroDTO;
    }

    @Override
    public StudentFinancialDto.Response guardarFinanciero(StudentFinancialDto.Request request) {
        //*Insertar datos*//*
        StudentFinancialManagerEntity alumnoFinancieroEntity = new StudentFinancialManagerEntity();
        alumnoFinancieroEntity.setId(request.getId());


        StudentEntity alumnoEntity = new StudentEntity();
        alumnoEntity.setId(request.getIdAlumno());

        RegisterEntity matriculaEntity = new RegisterEntity();
        matriculaEntity.setId(request.getIdMatricula());

        alumnoFinancieroEntity.setStudent(alumnoEntity);
        alumnoFinancieroEntity.setRegister(matriculaEntity);

        StudentFinancialManagerEntity alumnoFinancieroGuardado=repository.save(alumnoFinancieroEntity);

                /*Mostrar datos*/
        StudentFinancialDto.Response alumnoFinancieroDto = new StudentFinancialDto.Response();
        alumnoFinancieroDto.setId(alumnoFinancieroGuardado.getId());

        Optional<StudentEntity> alumno = alumnoRespository.findById(alumnoFinancieroGuardado.getStudent().getId());
        PersonDto person = new PersonDto();
        person.setName(alumno.get().getPerson().getName());
        person.setApellido_paterno(alumno.get().getPerson().getLastName());
        alumnoFinancieroDto.setAlumno(person);

        return alumnoFinancieroDto;
    }

    @Override
    public void eliminarFinanciero(Long id) {
        repository.deleteById(id);
    }


}
