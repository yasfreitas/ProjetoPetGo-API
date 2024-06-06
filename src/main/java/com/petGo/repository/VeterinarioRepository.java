package com.petGo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.petGo.entities.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{
	List<Veterinario> findByNome(String nome);
	List<Veterinario> findByCidade(String cidade);
	
	@Query("SELECT v FROM Veterinario v JOIN v.especialidade e WHERE e.id = :especialidadeId")
	List<Veterinario>findByEspecialidadeId(@Param("especialidadeId") Long especialidadeId);
	
	

}
