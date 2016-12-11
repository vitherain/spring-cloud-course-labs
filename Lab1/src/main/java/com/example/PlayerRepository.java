package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vít on 11. 12. 2016.
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
