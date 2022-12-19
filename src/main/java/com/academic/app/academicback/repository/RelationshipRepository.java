package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.GradeEntity;
import com.academic.app.academicback.entity.RelationshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RelationshipRepository extends JpaRepository<RelationshipEntity,Long> {

    public List<RelationshipEntity> findAllByName(String name);
}
