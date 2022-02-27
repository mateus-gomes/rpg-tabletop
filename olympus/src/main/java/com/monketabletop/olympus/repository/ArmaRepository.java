package com.monketabletop.olympus.repository;

import com.monketabletop.olympus.tables.ArmasTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmaRepository extends JpaRepository<ArmasTable, Integer> {
}
