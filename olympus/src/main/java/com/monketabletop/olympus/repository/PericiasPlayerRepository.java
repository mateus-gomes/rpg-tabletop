package com.monketabletop.olympus.repository;

import com.monketabletop.olympus.tables.PericiasPlayerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PericiasPlayerRepository extends JpaRepository<PericiasPlayerTable, Integer> {

    @Query(value = "SELECT * FROM Pericia_Player WHERE fk_player = ?1 AND fk_pericia = ?2", nativeQuery = true)
    PericiasPlayerTable findPericia(int fkPlayer, int fkPericia);
}
