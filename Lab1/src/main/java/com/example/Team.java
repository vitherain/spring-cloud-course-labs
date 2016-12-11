package com.example;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

/**
 * Created by Vít on 11. 12. 2016.
 */
@XmlRootElement
@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    private String mascotte;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="teamId")
    private Set<Player> players;

    public Team() {
    }

    public Team(String location, String mascotte, String name, Set<Player> players) {
        this.location = location;
        this.mascotte = mascotte;
        this.name = name;
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMascotte() {
        return mascotte;
    }

    public void setMascotte(String mascotte) {
        this.mascotte = mascotte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
