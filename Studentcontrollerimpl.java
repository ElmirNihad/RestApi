package org.example.springdata.controller;

import jakarta.validation.Valid;
import org.example.springdata.Services.IstudentServices;
import org.example.springdata.Services.Studentservicesimpl;
import org.example.springdata.dto.DtoStudent;
import org.example.springdata.dto.DtoStudentIU;
import org.example.springdata.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/student")
public class Studentcontrollerimpl implements İStudentcontroller{

    @Autowired
    private IstudentServices studentservice;

    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU Dtostudent) {
        return studentservice.saveStudent(Dtostudent);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getallStudentList() {
        return studentservice.getallStudentList();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
        return studentservice.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudent(@PathVariable(name = "id") Integer id) {
        studentservice.deleteStudent(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU updatestudent) {
        return studentservice.updateStudent(id, updatestudent);
    }


}
