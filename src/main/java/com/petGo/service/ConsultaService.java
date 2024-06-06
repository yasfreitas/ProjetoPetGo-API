package com.petGo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petGo.entities.Consulta;
import com.petGo.repository.ConsultaRepository;

@Service    
public class ConsultaService {    
	private final ConsultaRepository consultaRepository;      
	@Autowired      
	public ConsultaService(ConsultaRepository consultaRepository) {      
		this.consultaRepository = consultaRepository;      
	}     
	public List<Consulta> buscaTodosConsultas() {      
		return consultaRepository.findAll();     
	}     
	public Consulta buscaConsultaId(Long id) {      
		Optional <Consulta> consulta = consultaRepository.findById(id);     
		return consulta.orElse(null);     
	}     
	public List<Consulta> buscarConsultasPorData(String data){ 
		return consultaRepository.findByData(data); 
	} 
	public List<Consulta> buscarConsultasPorHora(String hora){ 
		return consultaRepository.findByHora(hora); 
	} 
	public List<Consulta> buscarConsultasPorPet(Long id_pet){ 
		return consultaRepository.findByPetId(id_pet); 
	} 
	public List<Consulta> buscarConsultasPorVeterinario(Long id_veterinario){ 
		return consultaRepository.findByVeterinarioId(id_veterinario); 
	} 
	public Consulta salvaConsulta(Consulta consulta) {      
		return consultaRepository.save(consulta);      
	}     
	public Consulta alterarConsulta(Long id, Consulta alterarUser) {      
		Optional <Consulta> existeConsulta = consultaRepository.findById(id);      
		if (existeConsulta.isPresent()) {      
			alterarUser.setId(id);      
			return consultaRepository.save(alterarUser);      
		}     
		return null;      
	}     
	public boolean apagarConsulta(Long id) {     
		Optional <Consulta> existeConsulta = consultaRepository.findById(id);      
		if (existeConsulta.isPresent()) {      
			consultaRepository.deleteById(id);      
			return true;      
		}    
		return false;      
	}    
} 