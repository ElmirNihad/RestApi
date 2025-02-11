package org.example.springdata.Services;

import org.example.springdata.dto.DtoStudent;
import org.example.springdata.dto.DtoStudentIU;
import org.example.springdata.entities.Student;
import org.example.springdata.repository.Studentrepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Studentservicesimpl implements IstudentServices{

    @Autowired
    private Studentrepository repository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU Dtostudent) {
        DtoStudent response = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(Dtostudent, student);
        Student dbstudent = repository.save(student);
        BeanUtils.copyProperties(dbstudent, response);
        return response;
    }

    @Override
    public List<DtoStudent> getallStudentList() {
        List<DtoStudent> response = new ArrayList<>();
        List<Student> students = repository.findAll();
        for (Student student : students) {
            DtoStudent dtostudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtostudent);
            response.add(dtostudent);
        }
        return response;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        DtoStudent response = new DtoStudent();
        Optional<Student> optional = repository.findById(id);

    if (optional.isPresent()) {
         Student dbstudent = optional.get();
         BeanUtils.copyProperties(dbstudent, response);
         return response;
    }
    return null;
    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
        }
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU updatestudent) {
        DtoStudent response = new DtoStudent();
        Optional<Student> optional = repository.findById(id);
        if (optional.isPresent()) {
           Student dbstudent = optional.get();
           dbstudent.setFirstname(updatestudent.getFirstname());
           dbstudent.setLastname(updatestudent.getLastname());
           dbstudent.setBirthofdate(updatestudent.getBirthofdate());
           Student student2 = repository.save(dbstudent);
           BeanUtils.copyProperties(student2, response);
           return response;
        }
        return null;
    }


}
