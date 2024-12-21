package com.maoziy.yurtify.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "dormitory")
@Data
public class DormitoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "room_capacity", nullable = false)
    private Integer roomCapacity;

    @Column(name = "total_capacity", nullable = false)
    private Integer totalCapacity;

    @Column(name = "number_registered", nullable = false)
    private Integer numberRegistered;

    @Column(name = "floor", nullable = false)
    private Integer floor;

    @Column(name = "dorm_type", nullable = false)
    private Integer dormType;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "com_id", referencedColumnName = "id", nullable = false)
    private CommunicationEntity communication;
}
