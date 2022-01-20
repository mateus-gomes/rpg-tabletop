package com.monketabletop.olympus.repository;

import com.monketabletop.olympus.tables.AtributosPlayerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AtributosPlayerRepository extends JpaRepository<AtributosPlayerTable, Integer> {

    @Query(value = "SELECT * FROM Atributos_Player WHERE fk_player = ?1 AND fk_atributo = ?2", nativeQuery = true)
    Optional<AtributosPlayerTable> findByPlayerAndAtributo(int fkPlayer, int fkAtributo);

    @Query(value = "SELECT * FROM Atributos_Player WHERE fk_player = ?1", nativeQuery = true)
    List<AtributosPlayerTable> findAtributos(int fkPlayer);
}
