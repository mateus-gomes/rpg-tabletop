package com.monketabletop.olympus.controller;

import com.monketabletop.olympus.DiceClass;
import com.monketabletop.olympus.tables.AtributosPlayerTable;
import com.monketabletop.olympus.service.PlayerService;
import com.monketabletop.olympus.tables.PericiasPlayerTable;
import com.monketabletop.olympus.tables.PlayersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity getPlayers(){
        List<PlayersTable> listPlayers = playerService.getPlayersInfo();

        if(listPlayers.isEmpty()){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.status(200).body(listPlayers);
        }
    }

    @GetMapping("/{idPlayer}")
    public ResponseEntity getPlayerInfo(@PathVariable int idPlayer){
        PlayersTable player = playerService.getPlayerInfo(idPlayer);

        if(player != null){
            return ResponseEntity.status(200).body(player);
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idPlayer}/pericias/{idPericia}")
    public ResponseEntity rollAttribute(@PathVariable int idPlayer, @PathVariable int idPericia){
        return ResponseEntity.status(200).body(playerService.rollATest(idPlayer, idPericia));
    }

    @PostMapping
    public ResponseEntity savePlayer(@RequestBody PlayersTable playersTable){
        playersTable.setEnergiaAtual(0);
        playersTable.setEnergiaMaxima(0);
        playersTable.setVidaAtual(0);
        playersTable.setVidaMaxima(0);
        playersTable.setNivel(1);

        if(playerService.createPlayer(playersTable)){
            return ResponseEntity.status(201).build();
        }else{
            return ResponseEntity.status(204).build();
        }
    }

    @PostMapping("/atributo")
    public ResponseEntity saveAtributo(@RequestBody AtributosPlayerTable atributosPlayerTable){
        boolean createResult = playerService.createOrUpdateAtributoPlayer(atributosPlayerTable);

        if(createResult){
            return ResponseEntity.status(201).build();
        }else{
            return ResponseEntity.status(204).build();
        }
    }

    @PostMapping("/pericia")
    public ResponseEntity savePericia(@RequestBody PericiasPlayerTable periciasPlayerTable){
        boolean createResult = playerService.createOrUpdatePericiaPlayer(periciasPlayerTable);

        if(createResult){
            return ResponseEntity.status(201).build();
        }else{
            return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("/roll/{diceSides}")
    public ResponseEntity rollDice(@PathVariable int diceSides){
        DiceClass diceClass = new DiceClass();

        return ResponseEntity.status(200).body(diceClass.rollDice(diceSides));
    }
}