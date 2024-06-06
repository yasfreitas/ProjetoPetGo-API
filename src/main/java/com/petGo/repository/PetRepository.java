package com.petGo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.petGo.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{
	List<Pet> findByNome(String nome);
	
	@Query("SELECT p FROM Pet p JOIN p.proprietario pro WHERE pro.id = :proprietarioId")
	List<Pet>findByProprietarioId(@Param("proprietarioId") Long proprietarioId);

}
