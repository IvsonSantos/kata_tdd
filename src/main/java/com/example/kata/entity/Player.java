package com.example.kata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Player")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Player {

    public static final char TYPE_X = 'X';
    public static final char TYPE_O = 'O';

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "type")
    private char type;

    @Column(name = "isTurn")
    private Boolean isTurn;

    public Player(char type, Boolean isTurn) {
        this.type = type;
        this.isTurn = isTurn;
    }

}
