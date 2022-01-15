package com.monketabletop.olympus.repository;

import com.monketabletop.olympus.tables.PlayersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<PlayersTable, Integer> {

    @Query(value = "SELECT * FROM Players WHERE fk_usuario = ?1", nativeQuery = true)
    List<PlayersTable> findByUsuario(int fkUsuario);
}
