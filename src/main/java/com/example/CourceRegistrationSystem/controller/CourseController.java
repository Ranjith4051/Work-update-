package com.example.CourceRegistrationSystem.controller;


import com.example.CourceRegistrationSystem.model.Course;
import com.example.CourceRegistrationSystem.model.CourseRegistry;
import com.example.CourceRegistrationSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CourseController {

    @Autowired
    CourseService c;
    @GetMapping("/courses")
    public List<Course> getAllCourse(){
        return c.getAllCourse();
    }

    @GetMapping("/courses/enroll")
    public List<CourseRegistry> getAllEnrolledStudents(){
        return c.getAllEnrolledStudents();
    }

//    @PostMapping("/courses/register")
//    public String registerCourse(@RequestParam("name")String name,
//                                @RequestParam("emailId") String email,
//                                 @RequestParam("courseName") String cr){
//        c.registerCourse(name,email,cr);
//        return "Hi"+" "+ name+" "+"Successfully Registered";
//    }
@PostMapping("/courses/register")
public String registerCourse(@RequestBody CourseRegistry enrollment){
    c.registerCourse(enrollment.getName(), enrollment.getEmailId(), enrollment.getCourseName());
    return "Hi " + enrollment.getName() + " Successfully Registered";
}

}
