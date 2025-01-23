package com.devmath.dslist.services;

import com.devmath.dslist.dto.GameDTO;
import com.devmath.dslist.dto.GameMinDTO;
import com.devmath.dslist.entities.Game;
import com.devmath.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired // dependency injection
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        List<GameMinDTO> dto = games.stream().map(GameMinDTO::new).toList();
        // dto = games.stream().map(x -> new GameMinDTO(x)).toList(); // another way to do the same
        return dto;
    }

    @Transactional(readOnly = true) // ensures that the transaction with the DB obey the ACID principles
    public GameDTO findById(Long id) {
        // findById returns an optional, .get() to get the information of this return
        Game game = gameRepository.findById(id).get();
        // GameDTO gameDTO = new GameDTO(game);
        return new GameDTO(game);
    }

}
