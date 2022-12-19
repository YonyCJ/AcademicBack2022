package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GradeRepository extends JpaRepository<GradeEntity,Long> {

    public List<GradeEntity> findAllByName(String name);
}
