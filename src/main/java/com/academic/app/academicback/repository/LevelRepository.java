package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.LevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LevelRepository extends JpaRepository<LevelEntity,Long> {

    public List<LevelEntity> findAllByName(String name);
}
