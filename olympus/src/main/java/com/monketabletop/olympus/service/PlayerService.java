package com.monketabletop.olympus.service;


import com.monketabletop.olympus.DiceClass;
import com.monketabletop.olympus.entity.RollResult;
import com.monketabletop.olympus.repository.*;
import com.monketabletop.olympus.tables.AtributosPlayerTable;
import com.monketabletop.olympus.tables.InventariosTable;
import com.monketabletop.olympus.tables.PericiasPlayerTable;
import com.monketabletop.olympus.tables.PlayersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PericiasPlayerRepository periciasPlayerRepository;

    @Autowired
    private PericiasRepository periciasRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AtributosPlayerRepository atributosPlayerRepository;

    @Autowired
    private AtributosRepository atributosRepository;

    @Autowired
    private InventariosRepository inventariosRepository;

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
        Optional<PericiasPlayerTable> periciasPlayerTable = periciasPlayerRepository.findByPlayerAndPericia(fkPlayer, fkPericia);

        int diceResult = diceClass.rollDice(20);
        int periciaValue = periciasPlayerTable.get().getPontos();
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

    public boolean createOrUpdateAtributoPlayer(AtributosPlayerTable atributosPlayerTable){
        Optional<AtributosPlayerTable> atributosPlayerTable2 = atributosPlayerRepository.findByPlayerAndAtributo(
                atributosPlayerTable.getFkPlayer().getIdPlayer(),
                atributosPlayerTable.getFkAtributo().getIdAtributo()
        );

        if(!atributosRepository.existsById(atributosPlayerTable.getFkAtributo().getIdAtributo())){
            return false;
        }

        if(!playerRepository.existsById(atributosPlayerTable.getFkPlayer().getIdPlayer())){
            return false;
        }

        if(atributosPlayerTable2.isPresent()){
            atributosPlayerTable2.get().setPontos(atributosPlayerTable.getPontos());
            atributosPlayerRepository.save(atributosPlayerTable2.get());
            return true;
        }else{
            atributosPlayerRepository.save(atributosPlayerTable);
            return true;
        }
    }

    public boolean createOrUpdatePericiaPlayer(PericiasPlayerTable periciasPlayerTable){
        Optional<PericiasPlayerTable> periciasPlayerTable2 = periciasPlayerRepository.findByPlayerAndPericia(
                periciasPlayerTable.getFkPlayer().getIdPlayer(),
                periciasPlayerTable.getFkPericia().getIdPericia()
        );

        if(!periciasRepository.existsById(periciasPlayerTable.getFkPericia().getIdPericia())){
            return false;
        }

        if(!playerRepository.existsById(periciasPlayerTable.getFkPlayer().getIdPlayer())){
            return false;
        }

        if(periciasPlayerTable2.isPresent()){
            periciasPlayerTable2.get().setPontos(periciasPlayerTable.getPontos());
            periciasPlayerRepository.save(periciasPlayerTable2.get());
            return true;
        }else{
            periciasPlayerRepository.save(periciasPlayerTable);
            return true;
        }
    }

    public boolean addItem(InventariosTable inventariosTable){
        if(playerRepository.existsById(inventariosTable.getFkPlayer().getIdPlayer())){
            inventariosRepository.save(inventariosTable);
            return true;
        }

        return false;
    }

    public boolean deleteItem(int idItem){
        Optional<InventariosTable> inventariosTable = inventariosRepository.findById(idItem);

        if(inventariosTable.isPresent()){
            inventariosRepository.delete(inventariosTable.get());
            return true;
        }

        return false;
    }

    public List<AtributosPlayerTable> getAtributos(int idPlayer){
        return atributosPlayerRepository.findAtributos(idPlayer);
    }
}
