package com.monketabletop.olympus.service;

import com.monketabletop.olympus.DiceClass;
import com.monketabletop.olympus.repository.ArmaRepository;
import com.monketabletop.olympus.repository.EfeitoArmaRepository;
import com.monketabletop.olympus.repository.PlayerRepository;
import com.monketabletop.olympus.tables.ArmasTable;
import com.monketabletop.olympus.tables.EfeitosArmaTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArmaService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private EfeitoArmaRepository efeitoArmaRepository;

    @Autowired
    private ArmaRepository armaRepository;

    /*public int dealDamage(int idPlayer, int idArma){
        DiceClass diceClass = new DiceClass();

        diceClass.rollDamage("");

         * Adicionar as tabelas armas, efeitosArma
         * Busca a arma,
         * Se não existir, joga uma exception de noSuchElement
         * Se existir rola o dano,
         * Busca os efeitosArma e aplicam eles,
         * Calcula o dano contra a armadura e escudo,
         * Atualiza a vida do player subtraindo o dano que recebeu

        return 0;
    }*/

    public boolean createArma(ArmasTable armasTable) {
        int fkPlayer = armasTable.getFkPlayer().getIdPlayer();
        int fkEfeitoArma = armasTable.getFkEfeitosArma().getIdEfeitoArma();

        if(playerRepository.existsById(fkPlayer) && efeitoArmaRepository.existsById(fkEfeitoArma)){
            armaRepository.save(armasTable);
            return true;
        }

        return false;
    }

    public boolean createEfeitoArma(EfeitosArmaTable efeitosArmaTable){
        efeitoArmaRepository.save(efeitosArmaTable);
        return true;
    }
}
