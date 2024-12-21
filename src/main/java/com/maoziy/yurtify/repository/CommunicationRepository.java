package com.maoziy.yurtify.repository;

import com.maoziy.yurtify.model.entity.CommunicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommunicationRepository extends JpaRepository<CommunicationEntity, UUID> {
}
