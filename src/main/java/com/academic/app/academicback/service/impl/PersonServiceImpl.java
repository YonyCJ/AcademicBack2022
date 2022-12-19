package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.PersonDto;
import com.academic.app.academicback.entity.PersonEntity;
import com.academic.app.academicback.repository.PersonRepository;
import com.academic.app.academicback.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository respository;

    public List<PersonDto> listarPersonas(){
        List<PersonEntity> listaPersonEntity =respository.findAll();

        List<PersonDto> listaPersonDTO = new ArrayList<>();

        for (PersonEntity personEntity : listaPersonEntity){
            PersonDto personDto = new PersonDto();
            personDto.setId(personEntity.getId());
            personDto.setName(personEntity.getName());

            listaPersonDTO.add(personDto);
        }

        return listaPersonDTO;
    }

    @Override
    public PersonDto obtenerPersonaPorId(Long id) {
        Optional<PersonEntity> personEntity =respository.findById(id);
        PersonDto personDTO = new PersonDto();
        if(personEntity.isPresent()){
            personDTO.setId(personEntity.get().getId());
            personDTO.setName(personEntity.get().getName());
        }else {
            return new PersonDto();
        }
        return personDTO;
    }

    @Override
    public PersonDto guardarPersona(PersonDto request) {
                /*Insertar datos*/
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(request.getId());
        personEntity.setName(request.getName());
        personEntity.setLastName(request.getApellido_paterno());
        personEntity.setLastNameM(request.getApellido_materno());

        PersonEntity personaGuardada=respository.save(personEntity);
                /*Mostrar datos*/
        PersonDto personDto = new PersonDto();
        personDto.setName(personaGuardada.getName());

        return personDto;
    }

    @Override
    public void eliminarPersona(Long id) {
        respository.deleteById(id);
    }


}
