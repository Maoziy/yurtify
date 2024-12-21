package com.maoziy.yurtify.repository;

import com.maoziy.yurtify.model.entity.DormDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DormDetailRepository extends JpaRepository<DormDetailEntity, UUID> {
}
