package com.monketabletop.olympus.controller;

import com.monketabletop.olympus.entity.Login;
import com.monketabletop.olympus.service.UsuarioService;
import com.monketabletop.olympus.tables.PlayersTable;
import com.monketabletop.olympus.tables.UsuariosTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity loginRoute(@RequestBody Login login){
        UsuariosTable usuariosTable = usuarioService.login(login);

        if(usuariosTable != null){
            return ResponseEntity.status(200).body("Login realizado com sucesso!");
        }

        return ResponseEntity.status(400).body("Credenciais incorretas!");
    }

    @GetMapping("/personagens/{idUsuario}")
    public ResponseEntity getCharactersRoute(@PathVariable int idUsuario){
        List<PlayersTable> characters = usuarioService.getCharacters(idUsuario);

        if(characters.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(characters);
    }
}
