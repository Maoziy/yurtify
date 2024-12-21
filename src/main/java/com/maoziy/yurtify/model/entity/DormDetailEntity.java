package com.maoziy.yurtify.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity(name = "Dorm_detail")
@Table
@Data
public class DormDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(name = "detail_text", nullable = false)
    private String detailText;

    @Column(name = "facility_text")
    private String facilityText;

    @OneToOne(mappedBy = "dormDetailEntity")
    private DormitoryEntity dormitory;
}
