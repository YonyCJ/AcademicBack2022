package com.academic.app.academicback.service.impl;

import com.academic.app.academicback.dto.RelationShipDto;
import com.academic.app.academicback.entity.RelationshipEntity;
import com.academic.app.academicback.repository.RelationshipRepository;
import com.academic.app.academicback.service.RelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RelationShipServiceImpl implements RelationShipService {

    @Autowired
    private RelationshipRepository respository;

    public List<RelationShipDto> listarParentesco(){
        List<RelationshipEntity> listaParentescoEntity =respository.findAll();

        List<RelationShipDto> listaParentescoDTO = new ArrayList<>();

        for (RelationshipEntity parentescoEntity : listaParentescoEntity){
            RelationShipDto parentescoDto = new RelationShipDto();
            parentescoDto.setId(parentescoEntity.getId());
            parentescoDto.setNombres(parentescoEntity.getName());
            parentescoDto.setDescripcion(parentescoEntity.getDescription());

            listaParentescoDTO.add(parentescoDto);
        }

        return listaParentescoDTO;
    }

    @Override
    public RelationShipDto obtenerParentescoPorId(Long id) {
        Optional<RelationshipEntity> parentescoEntity =respository.findById(id);
        RelationShipDto parentescoDTO = new RelationShipDto();
        if(parentescoEntity.isPresent()){
            parentescoDTO.setId(parentescoEntity.get().getId());
            parentescoDTO.setNombres(parentescoEntity.get().getName());
            parentescoDTO.setDescripcion(parentescoEntity.get().getDescription());

        }else {
            return new RelationShipDto();
        }
        return parentescoDTO;
    }

    @Override
    public RelationShipDto guardarParentesco(RelationShipDto request) {
                /*Insertar datos*/
        RelationshipEntity parentescoEntity = new RelationshipEntity();
        parentescoEntity.setId(request.getId());
        parentescoEntity.setName(request.getNombres());
        parentescoEntity.setDescription(request.getDescripcion());

        RelationshipEntity parentescoGuardado=respository.save(parentescoEntity);
                /*Mostrar datos*/
        RelationShipDto parentescoDto = new RelationShipDto();
        parentescoDto.setNombres(parentescoGuardado.getName());
        parentescoDto.setDescripcion(parentescoGuardado.getDescription());

        return parentescoDto;
    }

    @Override
    public void eliminarParentesco(Long id) {
        respository.deleteById(id);
    }


}
