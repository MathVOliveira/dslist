package com.devmath.dslist.repositories;

import com.devmath.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    // JpaRepository<Entity, type of entity id>
}
