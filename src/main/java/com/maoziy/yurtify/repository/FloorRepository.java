package com.maoziy.yurtify.repository;

import com.maoziy.yurtify.model.entity.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FloorRepository extends JpaRepository<FloorEntity, UUID> {

    List<FloorEntity> findAllByDormitoryEntity_Id(UUID id);
}
