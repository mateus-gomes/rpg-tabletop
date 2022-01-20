package com.monketabletop.olympus.repository;

import com.monketabletop.olympus.tables.InventariosTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventariosRepository extends JpaRepository<InventariosTable, Integer> {
}
