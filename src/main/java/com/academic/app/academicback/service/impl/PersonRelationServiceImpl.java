package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.PersonDto;
import com.academic.app.academicback.dto.PersonRelationDto;
import com.academic.app.academicback.dto.RelationShipDto;
import com.academic.app.academicback.entity.PersonEntity;
import com.academic.app.academicback.entity.PersonRelationEntity;
import com.academic.app.academicback.entity.RelationshipEntity;
import com.academic.app.academicback.repository.PersonRelationshipRepository;
import com.academic.app.academicback.repository.PersonRepository;
import com.academic.app.academicback.repository.RelationshipRepository;
import com.academic.app.academicback.service.PersonRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonRelationServiceImpl implements PersonRelationService {

    @Autowired
    private PersonRelationshipRepository respository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RelationshipRepository parentescoRespository;

    public List<PersonRelationDto.Response> listarPersParentesco(){
        List<PersonRelationEntity> listaPersParentescoEntity =respository.findAll();

        List<PersonRelationDto.Response> listaPersParentescoDTO = new ArrayList<>();

        for (PersonRelationEntity persparentescoEntity : listaPersParentescoEntity){
            PersonRelationDto.Response persparentescoDto = new PersonRelationDto.Response();
            persparentescoDto.setId(persparentescoEntity.getId());

            Optional<PersonEntity> persona = personRepository.findById(persparentescoEntity.getId());
            PersonDto person = new PersonDto();
            person.setName(persona.get().getName());
            person.setApellido_paterno(persona.get().getLastName());
            person.setApellido_materno(persona.get().getLastNameM());
            persparentescoDto.setPersona(person);

            Optional<RelationshipEntity> parentesco = parentescoRespository.findById(persparentescoEntity.getId());
            RelationShipDto relationShip = new RelationShipDto();
            relationShip.setNombres(parentesco.get().getName());
            relationShip.setDescripcion(parentesco.get().getDescription());
            persparentescoDto.setParentesco(relationShip);


            listaPersParentescoDTO.add(persparentescoDto);
        }

        return listaPersParentescoDTO;
    }

    @Override
    public PersonRelationDto.Response obtenerPersParentescoPorId(Long id) {

        PersonRelationDto.Response persparentescoDTO = new PersonRelationDto.Response();
        Optional<PersonRelationEntity> persparentescoEntity =respository.findById(id);

        if(persparentescoEntity.isPresent()){
            persparentescoDTO.setId(persparentescoEntity.get().getId());

            Optional<PersonEntity> persona = personRepository.findById(persparentescoEntity.get().getId());
            PersonDto person = new PersonDto();
            person.setName(persona.get().getName());
            person.setApellido_paterno(persona.get().getLastName());
            persparentescoDTO.setPersona(person);

            Optional<RelationshipEntity> parentesco = parentescoRespository.findById(persparentescoEntity.get().getId());
            RelationShipDto relationShip = new RelationShipDto();
            relationShip.setNombres(parentesco.get().getName());
            relationShip.setDescripcion(parentesco.get().getDescription());
            persparentescoDTO.setParentesco(relationShip);

        }else {
            return new PersonRelationDto.Response();
        }
        return persparentescoDTO;
    }

    @Override
    public PersonRelationDto.Response guardarPersParentesco(PersonRelationDto.Request request) {
                /*Insertar datos*/
        PersonRelationEntity perparentescoEntity = new PersonRelationEntity();
        perparentescoEntity.setId(request.getId());
        perparentescoEntity.setCondition(request.getEstado());

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(request.getIdPersona());

        RelationshipEntity parentescoEntity = new RelationshipEntity();
        parentescoEntity.setId(request.getIdParentesco());

        perparentescoEntity.setPerson(personEntity);
        perparentescoEntity.setRelationship(parentescoEntity);

        PersonRelationEntity parentescoGuardado=respository.save(perparentescoEntity);
                /*Mostrar datos*/
        PersonRelationDto.Response perparentescoDto = new PersonRelationDto.Response();
        perparentescoDto.setId(parentescoGuardado.getId());

        Optional<PersonEntity> person = personRepository.findById(parentescoGuardado.getPerson().getId());
        PersonDto persona = new PersonDto();
        persona.setName(person.get().getName());
        persona.setApellido_paterno(person.get().getLastName());
        perparentescoDto.setPersona(persona);

        return perparentescoDto;
    }

    @Override
    public void eliminarPersParentesco(Long id) {
        respository.deleteById(id);
    }


}
