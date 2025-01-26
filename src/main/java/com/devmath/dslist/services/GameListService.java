package com.devmath.dslist.services;

import com.devmath.dslist.dto.GameListDTO;
import com.devmath.dslist.entities.GameList;
import com.devmath.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> list = gameListRepository.findAll();
        return list.stream().map(GameListDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        // findById returns an optional, "get()" to get what's inside
        return new GameListDTO(gameListRepository.findById(id).get());
    }



}
