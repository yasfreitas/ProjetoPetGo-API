package com.petGo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.petGo.entities.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long>{
	List<Proprietario> findByCidade(String cidade);
	List<Proprietario> findByNome(String nome);
	
	@Query("SELECT p FROM Proprietario p WHERE p.nomeCompleto LIKE :nomeCompleto")
	List<Proprietario>findByNomeLike(@Param("nomeCompleto") String nomeCompleto);

}
