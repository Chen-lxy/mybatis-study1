package com.chen.mybatis.mapper;

import com.chen.mybatis.entity.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> queryAllStudents();

    Student queryStudentById(Integer id);

    int addStudent(Student student);

    int deleteStudent(Integer id);

    int updateStudent(Student student);


}
