package com.maoziy.yurtify.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Room")
@Data
@Builder
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    @ManyToOne
    private DormitoryEntity dormId;

    @ManyToOne
    private FloorEntity floorId;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "number_of_student")
    private Integer numberOfStudent;


}
