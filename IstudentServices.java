package org.example.springdata.Services;

import org.example.springdata.dto.DtoStudent;
import org.example.springdata.dto.DtoStudentIU;
import org.example.springdata.entities.Student;

import java.util.List;

public interface IstudentServices {
    public DtoStudent saveStudent(DtoStudentIU Dtostudent);

    public List<DtoStudent> getallStudentList();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id , DtoStudentIU updatestudent);
}
