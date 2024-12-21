package com.maoziy.yurtify.repository;

import com.maoziy.yurtify.model.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, UUID> {
    Optional<CityEntity> findByName(String city);
}
