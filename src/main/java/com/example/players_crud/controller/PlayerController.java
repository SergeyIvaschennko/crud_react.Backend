package com.example.players_crud.controller;

import com.example.players_crud.exception.PlayerNotFoundException;
import com.example.players_crud.model.Player;
import com.example.players_crud.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
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

    @GetMapping("/player/{id}")
    Player getplayerById(@PathVariable Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PutMapping("/player/{id}")
    Player updatePlayer(@RequestBody Player newPlayer, @PathVariable Long id) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setName(newPlayer.getName());
                    player.setLastname(newPlayer.getLastname());
                    player.setAge(newPlayer.getAge());
                    return playerRepository.save(player);
                }).orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @DeleteMapping("/player/{id}")
    String deletePlayer(@PathVariable Long id){
        if(!playerRepository.existsById(id)){
            throw new PlayerNotFoundException(id);
        }
        playerRepository.deleteById(id);
        return  "Player with id "+id+" has been deleted success.";
    }

}
