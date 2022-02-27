package com.monketabletop.olympus.controller;

import com.monketabletop.olympus.service.ArmaService;
import com.monketabletop.olympus.tables.ArmasTable;
import com.monketabletop.olympus.tables.EfeitosArmaTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/armas")
public class ArmaController {

    @Autowired
    private ArmaService armaService;

    @PostMapping
    public ResponseEntity saveArma(@RequestBody ArmasTable armasTable){
        if(armaService.createArma(armasTable)){
            return ResponseEntity.status(201).build();
        }else{
            return ResponseEntity.status(204).build();
        }
    }

    @PostMapping("/efeito")
    public ResponseEntity saveEfeitoArma(@RequestBody EfeitosArmaTable efeitosArmaTable){
        if(armaService.createEfeitoArma(efeitosArmaTable)){
            return ResponseEntity.status(201).build();
        }else{
            return ResponseEntity.status(204).build();
        }
    }

    /*@GetMapping("{idArma}/damage-player/{idPlayer}")
    public ResponseEntity rollDamage(@PathVariable int idArma, @PathVariable int idPlayer){


        return ResponseEntity.status(200).build();
    }*/
}
