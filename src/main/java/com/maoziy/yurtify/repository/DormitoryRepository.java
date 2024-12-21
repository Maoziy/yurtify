package com.maoziy.yurtify.repository;

import com.maoziy.yurtify.model.entity.DormitoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DormitoryRepository extends JpaRepository<DormitoryEntity, UUID> {

    Optional<DormitoryEntity> findByName(String name);

}
