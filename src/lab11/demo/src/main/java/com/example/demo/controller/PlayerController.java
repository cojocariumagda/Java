package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;


@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/all_player")
    public ResponseEntity<List<Player>> getAllPlayers(@RequestParam(required = false) String name)
    {
        try
        {
            System.out.println(playerRepository.findAll());
            List<Player> players = new ArrayList<>();

            if(name == null)
            {
                players.addAll(playerRepository.findAll());
            }

            if (players.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(players, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player)
    {
        try {
            Player _player = playerRepository.save(new Player(player.getIdPlayer(), player.getName()));
            return new ResponseEntity<>(_player, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/put/{id_player}")
    public ResponseEntity<Player> updatePlayer(@PathVariable("id_player") String id_player, @RequestBody Player player)
    {
        Optional<Player> playerData = playerRepository.findById(id_player);
        if (playerData.isPresent())
        {
            Player _player = playerData.get();
            _player.setName(player.getName());
            return new ResponseEntity<>(playerRepository.save(_player), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id_player}")
    public ResponseEntity<HttpStatus> deletePlayer (@PathVariable("id_player") String id_player)
    {
        try
        {
            Optional<Player> playerData = playerRepository.findById(id_player);
            if (playerData.isPresent()) {
                playerRepository.deleteById(id_player);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
