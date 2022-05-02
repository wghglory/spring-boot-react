package com.guanghui.springbootreact.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    private String brand, model, color, registerNumber;
    private int year, price;

    //    Suppose Car to owner is N to 1
    @ManyToOne(fetch = FetchType.LAZY)
    // create owner_id column in cars table, referencing owners table's owner_id column,
    // alter table cars add constraint FKhcsx2hgskre1qwetp67r7qfr foreign key (owner_id) references owners
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
