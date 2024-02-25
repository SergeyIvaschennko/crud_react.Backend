package com.example.players_crud.exception;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(Long id){
        super("Could not found the user with id "+ id);
    }
}
