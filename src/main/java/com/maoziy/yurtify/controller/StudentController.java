package com.maoziy.yurtify.controller;

import com.maoziy.yurtify.controller.request.SaveToRoomStudent;
import com.maoziy.yurtify.controller.request.StudentRequest;
import com.maoziy.yurtify.controller.response.BaseResponse;
import com.maoziy.yurtify.model.entity.StudentEntity;
import com.maoziy.yurtify.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping()
    public BaseResponse<?> createNewStudent(@RequestBody StudentRequest request) {
        return BaseResponse.success(service.createNewStudent(request));
    }

    @PostMapping("/room")
    public BaseResponse<?> saveStudentToRoom(@RequestBody SaveToRoomStudent saveToRoomStudent) {
        return BaseResponse.success(service.saveToRoomStudent(saveToRoomStudent));
    }

    @PutMapping("/{id}")
    public BaseResponse<StudentEntity> updateStudent(@PathVariable UUID id, @RequestBody StudentRequest request) {
        return BaseResponse.success(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public BaseResponse<String> delete(@PathVariable UUID id) {
        return BaseResponse.success(service.delete(id));
    }

    @GetMapping()
    public BaseResponse<List<StudentEntity>> getAll() {
        return BaseResponse.success(service.getAll());
    }
}
