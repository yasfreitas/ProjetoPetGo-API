package com.petGo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petGo.entities.Veterinario;
import com.petGo.repository.VeterinarioRepository;

@Service 
public class VeterinarioService {
	private final VeterinarioRepository veterinarioRepository;  
	@Autowired  
	public VeterinarioService(VeterinarioRepository veterinarioRepository) {  
		this.veterinarioRepository = veterinarioRepository;  
	}  
 
	public List<Veterinario> getAllVeterinarios() {  
		return veterinarioRepository.findAll();  
	}  
 
	public Veterinario getVeterinarioById(Long id) {  
		Optional<Veterinario> veterinario = veterinarioRepository.findById(id);  
		return veterinario.orElse(null);  
	}  
	//Query Method  
	public List<Veterinario> buscarVeterinariosPorNome(String nome) {  
		return veterinarioRepository.findByNome(nome);  
	}  
	//Query Method  
	public List<Veterinario> buscarVeterinariosPorCidade(String cidade) {  
			return veterinarioRepository.findByCidade(cidade);  
	}  
	//Query Method  
	public List<Veterinario> buscarVeterinariosPorEspecialidade(Long especialidadeId) {  
		return veterinarioRepository.findByEspecialidadeId(especialidadeId);  
	}  
 
	public Veterinario salvarVeterinario(Veterinario veterinario) {  
		return veterinarioRepository.save(veterinario);  
	}  
 
	public Veterinario updateVeterinario(Long id, Veterinario updatedVeterinario) {  
		Optional<Veterinario> existingVeterinario = veterinarioRepository.findById(id);  
		if (existingVeterinario.isPresent()) {  
			updatedVeterinario.setId(id);  
			return veterinarioRepository.save(updatedVeterinario);  
		}  
		return null;  
	}  
 
	public boolean deleteVeterinario(Long id) {  
		Optional<Veterinario> existingVeterinario = veterinarioRepository.findById(id);  
		if (existingVeterinario.isPresent()) { 
			veterinarioRepository.deleteById(id);  
			return true;  
		}  
		return false; 
	}  
} 
