package com.example.kata.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movement {

    private Integer id;
    private Character player;
    private Position position;

}
