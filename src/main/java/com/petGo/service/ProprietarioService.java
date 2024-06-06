package com.petGo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petGo.entities.Proprietario;
import com.petGo.repository.ProprietarioRepository;

@Service 
public class ProprietarioService { 
	private final ProprietarioRepository proprietarioRepository; 
	@Autowired 
	public ProprietarioService(ProprietarioRepository proprietarioRepository) { 
		this.proprietarioRepository = proprietarioRepository; 
	} 

	public List<Proprietario> getAllProprietarios() { 
		return proprietarioRepository.findAll(); 
	} 

	public Proprietario getProprietarioById(Long id) { 
		Optional<Proprietario> proprietario = proprietarioRepository.findById(id); 
		return proprietario.orElse(null); 
	} 
	//Query Method  
	public List<Proprietario> buscarProprietariosPorCidade(String cidade) { 
		return proprietarioRepository.findByCidade(cidade);  
	} 
	//Query Method  
	public List<Proprietario> buscarProprietariosPorNome(String nome) { 
			return proprietarioRepository.findByNome(nome);  
	}
	//Query Method  
	public List<Proprietario> buscarProprietariosPorNomeCompleto(String nomeCompleto) { 
				return proprietarioRepository.findByNomeLike(nomeCompleto);  
	}
		

	public Proprietario salvarProprietario(Proprietario proprietario) { 
		return proprietarioRepository.save(proprietario); 
	} 

	public Proprietario updateProprietario(Long id, Proprietario updatedProprietario) { 
		Optional<Proprietario> existingProprietario = proprietarioRepository.findById(id); 
		if (existingProprietario.isPresent()) { 
			updatedProprietario.setId(id); 
			return proprietarioRepository.save(updatedProprietario); 
		} 
		return null; 
	} 

	public boolean deleteProprietario(Long id) { 
		Optional<Proprietario> existingProprietario = proprietarioRepository.findById(id);
		if (existingProprietario.isPresent()) { 
			proprietarioRepository.deleteById(id); 
			return true; 
		}
		return false; 
	} 
} 