package com.monketabletop.olympus.service;

import com.monketabletop.olympus.entity.Login;
import com.monketabletop.olympus.repository.PlayerRepository;
import com.monketabletop.olympus.repository.UsuarioRepository;
import com.monketabletop.olympus.tables.PlayersTable;
import com.monketabletop.olympus.tables.UsuariosTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public UsuariosTable login(Login login){
        return usuarioRepository.findByNicknameAndSenha(login.getNickname(), login.getSenha());
    }

    public List<PlayersTable> getCharacters(int idUsuario){
        return playerRepository.findByUsuario(idUsuario);
    }
}
