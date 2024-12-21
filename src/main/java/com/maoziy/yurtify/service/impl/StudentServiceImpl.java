package com.maoziy.yurtify.service.impl;

import com.maoziy.yurtify.controller.request.SaveToRoomStudent;
import com.maoziy.yurtify.controller.request.StudentRequest;
import com.maoziy.yurtify.model.entity.RoomEntity;
import com.maoziy.yurtify.model.entity.StudentEntity;
import com.maoziy.yurtify.model.exception.NotFoundException;
import com.maoziy.yurtify.repository.RoomRepository;
import com.maoziy.yurtify.repository.StudentRepository;
import com.maoziy.yurtify.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final RoomRepository roomRepository;
    @Override
    public StudentEntity createNewStudent(StudentRequest request) {
        StudentEntity entity = new StudentEntity();
        entity.setGender(request.getGender());
        entity.setName(request.getName());
        entity.setPhone(request.getPhone());

        return repository.save(entity);
    }

    @Override
    public StudentEntity saveToRoomStudent(SaveToRoomStudent saveToRoomStudent) {
        RoomEntity roomEntity = roomRepository.findById(saveToRoomStudent.getRoomId())
                .orElseThrow(() -> new NotFoundException(saveToRoomStudent.getRoomId().toString()));

        StudentEntity studentEntity = repository.findById(saveToRoomStudent.getStudentId())
                .orElseThrow(() -> new NotFoundException(saveToRoomStudent.getRoomId().toString()));

        studentEntity.setRoomEntity(roomEntity);

        return repository.save(studentEntity);
    }

    @Override
    public StudentEntity update(UUID id, StudentRequest request) {
        StudentEntity studentEntity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));

        studentEntity.setName(request.getName());
        studentEntity.setPhone(request.getPhone());
        studentEntity.setGender(request.getGender());

        return repository.save(studentEntity);
    }

    @Override
    public String delete(UUID id) {
        repository.deleteById(id);

        return "record was deleted";
    }

    @Override
    public List<StudentEntity> getAll() {
        return repository.findAll();
    }
}
