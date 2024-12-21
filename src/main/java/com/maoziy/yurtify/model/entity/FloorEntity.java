package com.maoziy.yurtify.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Floor")
@Data
public class FloorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "dorm_id",referencedColumnName = "id")
    private DormitoryEntity dormitoryEntity;

    @Column(name = "floor_number")
    private Integer floorNumber;
    @Column(name = "number_of_rooms")
    private Integer numberOfRooms;
}
