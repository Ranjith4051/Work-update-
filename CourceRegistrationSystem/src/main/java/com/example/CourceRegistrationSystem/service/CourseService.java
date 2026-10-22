package com.example.CourceRegistrationSystem.service;

import com.example.CourceRegistrationSystem.model.Course;
import com.example.CourceRegistrationSystem.model.CourseRegistry;
import com.example.CourceRegistrationSystem.repository.CourseRegistryRepo;
import com.example.CourceRegistrationSystem.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRegistryRepo cprepo;

    @Autowired
    CourseRepo cp;
    public List<Course> getAllCourse() {
        return cp.findAll();
    }

    public List<CourseRegistry> getAllEnrolledStudents() {
        return cprepo.findAll();
    }

    public void registerCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry = new CourseRegistry(name, emailId, courseName);
        cprepo.save(courseRegistry);
    }

}
