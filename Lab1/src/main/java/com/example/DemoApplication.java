package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private TeamRepository teamRepository;

	@PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		Team team = new Team();
		Player player1 = new Player("Vit Herain", "Obrana");
		Player player2 = new Player("Radek Mazor", "Zaloha");
		team.setPlayers(new HashSet<>(Arrays.asList(player1, player2)));
		team.setLocation("Harlem");
		team.setName("Globetrotters");
		list.add(team);

		team = new Team();
		Player player3 = new Player("Ales Kavka", "Utok");
		team.setPlayers(new HashSet<>(Collections.singletonList(player3)));
		team.setLocation("Washington");
		team.setName("Generals");
		list.add(team);

		teamRepository.save(list);
	}
}
