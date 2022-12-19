package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.PersonEntity;
import com.academic.app.academicback.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRepository extends JpaRepository<PersonEntity,Long> {

    public List<PersonEntity> findAllByName(String name);
}
