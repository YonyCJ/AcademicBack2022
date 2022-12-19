package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    public List<StudentEntity> findAllByCode(String code);

    public List<StudentEntity> findAllById(Long id);
}
