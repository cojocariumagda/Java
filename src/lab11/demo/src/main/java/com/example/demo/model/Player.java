package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @Column(name = "id_player")
    private String idPlayer;

    @Column(name = "name")
    private String name;

    public Player() {

    }

    public Player(String id_player, String name)
    {
        this.idPlayer = id_player;
        this.name = name;
    }

    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "idPlayer='" + idPlayer + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
