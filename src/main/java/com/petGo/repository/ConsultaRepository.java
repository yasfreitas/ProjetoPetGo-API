package com.petGo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.petGo.entities.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
	List<Consulta> findByData(String data);
	List<Consulta> findByHora(String hora);
	
	@Query("SELECT c FROM Consulta c JOIN c.veterinario v WHERE v.id = :id_veterinario")
	List<Consulta>findByVeterinarioId(@Param("id_veterinario") Long id_veterinario);
	
	@Query("SELECT c FROM Consulta c JOIN c.pet p WHERE p.id = :id_pet")
	List<Consulta>findByPetId(@Param("id_pet") Long id_pet);

}
