package com.monketabletop.olympus.repository;

import com.monketabletop.olympus.tables.UsuariosTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuariosTable, Integer> {

    @Query(value = "SELECT * FROM Usuarios WHERE nickname = ?1 AND senha = ?2 ", nativeQuery = true)
    UsuariosTable findByNicknameAndSenha(String nickname, String senha);
}
