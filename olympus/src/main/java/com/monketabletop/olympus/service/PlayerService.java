package com.monketabletop.olympus.service;


import com.monketabletop.olympus.DiceClass;
import com.monketabletop.olympus.entity.RollResult;
import com.monketabletop.olympus.repository.PericiasPlayerRepository;
import com.monketabletop.olympus.repository.PlayerRepository;
import com.monketabletop.olympus.repository.UsuarioRepository;
import com.monketabletop.olympus.tables.PericiasPlayerTable;
import com.monketabletop.olympus.tables.PlayersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PericiasPlayerRepository periciasPlayerRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public PlayersTable getPlayerInfo(int idPlayer){
        if(playerRepository.existsById(idPlayer)){
            return playerRepository.findById(idPlayer).get();
        }

        return null;
    }

    public List<PlayersTable> getPlayersInfo(){
        return playerRepository.findAll();
    }

    public RollResult rollATest(int fkPlayer, int fkPericia){
        DiceClass diceClass = new DiceClass();
        PericiasPlayerTable periciasPlayerTable = periciasPlayerRepository.findPericia(fkPlayer, fkPericia);

        int diceResult = diceClass.rollDice(20);
        int periciaValue = periciasPlayerTable.getPontos();
        int chanceTesteBom = (int)Math.ceil((Double.parseDouble(String.valueOf(periciaValue)) - 1)/2);
        int chanceTesteExtremo = (int)Math.ceil((Double.parseDouble(String.valueOf(periciaValue)) - 4)/5);

        if(21-chanceTesteExtremo <= diceResult){
            return new RollResult("Extremo", diceResult);
        }else if(21-chanceTesteBom <= diceResult){
            return new RollResult("Bom", diceResult);
        }else if(periciaValue+diceResult >= 21){
            return new RollResult("Normal", diceResult);
        }else{
            return new RollResult("Fracasso", diceResult);
        }
    }

    public boolean createPlayer(PlayersTable playersTable){
        int fkUsuario = playersTable.getFkUsuario().getIdUsuario();

        if(usuarioRepository.existsById(fkUsuario)){
            playerRepository.save(playersTable);
            return true;
        }

        return false;
    }

}
