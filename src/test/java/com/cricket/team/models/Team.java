package com.cricket.team.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Team {
    @JsonProperty("name")
    private String name;
    @JsonProperty("location")
    private String location;
    @JsonProperty("player")
    private Player[] player;

    public Team(String name, String location, Player[] player) {
        this.name = name;
        this.location = location;
        this.player = player;
    }

    public Team(){}

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Player[] getPlayer() {
        return player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }
}
