package com.example.springsprinttask2.repositories;

import com.example.springsprinttask2.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CousesRep extends JpaRepository<Course, Long > {
}
