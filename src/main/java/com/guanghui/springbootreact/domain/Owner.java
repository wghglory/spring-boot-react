package com.guanghui.springbootreact.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owners")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;

    private String firstName;
    private String lastName;

    // 1 owner can have many cars
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    // mappedBy value is the field in Car class (private Owner `owner`)
    private List<Car> cars;
}
