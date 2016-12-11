package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Vít on 11. 12. 2016.
 */
@RestResource(path="teams", rel="team")
public interface TeamRepository extends JpaRepository<Team, Long> {
}
