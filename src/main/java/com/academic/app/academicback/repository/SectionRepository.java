package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.LevelEntity;
import com.academic.app.academicback.entity.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SectionRepository extends JpaRepository<SectionEntity,Long> {

    public List<SectionEntity> findAllByName(String name);
}
