package com.maoziy.yurtify.repository;

import com.maoziy.yurtify.model.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {

    List<RoomEntity> findAllByDormId_IdAndFloorId_Id(UUID dormId,UUID floorId);
}
