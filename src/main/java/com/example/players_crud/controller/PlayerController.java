package com.example.players_crud.controller;

import com.example.players_crud.model.Player;
import com.example.players_crud.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping("/player")
    Player newPlayer(@RequestBody Player newPlayer) {
        return playerRepository.save(newPlayer);
    }

    @GetMapping("/player")
    List<Player> getAllplayers() {
        return playerRepository.findAll();
    }

}
