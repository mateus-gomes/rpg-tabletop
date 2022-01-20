package com.monketabletop.olympus.repository;

import com.monketabletop.olympus.tables.PericiasPlayerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PericiasPlayerRepository extends JpaRepository<PericiasPlayerTable, Integer> {

    @Query(value = "SELECT * FROM Pericias_Player WHERE fk_player = ?1 AND fk_pericia = ?2", nativeQuery = true)
    Optional<PericiasPlayerTable> findByPlayerAndPericia(int fkPlayer, int fkPericia);
}
