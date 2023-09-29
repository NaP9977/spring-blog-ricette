package org.learning.ricette.repository;

import org.learning.ricette.model.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RicettaRepository extends JpaRepository <Ricetta, Integer> {

}
