package com.maoziy.yurtify.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Room")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "dorm_id", referencedColumnName = "id")
    private DormitoryEntity dormId;

    @ManyToOne()
    @JoinColumn(name = "floor_id", referencedColumnName = "id")
    private FloorEntity floorId;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "number_of_student")
    private Integer numberOfStudent;


}
