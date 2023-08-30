package com.example.springsprinttask2.services;

import com.example.springsprinttask2.models.Course;
import com.example.springsprinttask2.repositories.CousesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CousesRep cousesRep;

    public List<Course> getCourses(){
        return cousesRep.findAll();
    }
}
