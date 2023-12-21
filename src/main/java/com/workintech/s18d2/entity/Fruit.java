package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fruit", schema = "fsweb")
public class Fruit extends Vegetable {

    @Enumerated(EnumType.STRING)
    @Column(name= "fruit_type")
    private FruitType fruitType;
}
