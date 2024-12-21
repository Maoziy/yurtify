package com.maoziy.yurtify.service;

import com.maoziy.yurtify.controller.request.SaveToRoomStudent;
import com.maoziy.yurtify.controller.request.StudentRequest;
import com.maoziy.yurtify.model.entity.StudentEntity;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    StudentEntity createNewStudent(StudentRequest request);

    StudentEntity saveToRoomStudent(SaveToRoomStudent saveToRoomStudent);


    StudentEntity update(UUID id, StudentRequest request);

    String delete(UUID id);

    List<StudentEntity> getAll();
}
