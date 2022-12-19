package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.PersonRelationEntity;
import com.academic.app.academicback.entity.RelationshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRelationshipRepository extends JpaRepository<PersonRelationEntity,Long> {

    public List<PersonRelationEntity> findAllByPersonName(String name);
}
