package com.maoziy.yurtify.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Communication")
@Data
public class CommunicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false) // district_id Foreign Key
    private CityEntity city;

    @OneToOne(mappedBy = "communication",cascade = CascadeType.ALL)
    private DormitoryEntity dormitoryEntity;

}
