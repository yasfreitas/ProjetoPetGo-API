package com.petGo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petGo.entities.Consulta;
import com.petGo.service.ConsultaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/consulta") 
@Tag(name = "Consulta", description="API REST DE GERENCIAMENTO DE CONSULTA") 
public class ConsultaController { 

    private final ConsultaService consultaService; 

    @Autowired 
    public ConsultaController(ConsultaService consultaService) { 
        this.consultaService = consultaService; 
    } 

    //Query Method 
    @GetMapping("/data/{data}") 
    @Operation(summary = "Busca uma consulta por data")
    public ResponseEntity<List<Consulta>> buscarConsultasPorData(@PathVariable String data) { 
      List<Consulta> consultas = consultaService.buscarConsultasPorData(data); 
      return ResponseEntity.ok(consultas); 
    } 
    
  //Query Method 
    @GetMapping("/hora/{hora}") 
    @Operation(summary = "Busca uma consulta por hora")
    public ResponseEntity<List<Consulta>> buscarConsultasPorHora(@PathVariable String hora) { 
      List<Consulta> consultas = consultaService.buscarConsultasPorHora(hora); 
      return ResponseEntity.ok(consultas); 
    } 

  //Query Method 
    @GetMapping("/veterinario/{veterinario}") 
    @Operation(summary = "Busca uma consulta por veterinário")
    public ResponseEntity<List<Consulta>> buscarConsultasPorVeterinario(@PathVariable Long id_veterinario) { 
      List<Consulta> consultas = consultaService.buscarConsultasPorVeterinario(id_veterinario); 
      return ResponseEntity.ok(consultas); 
    } 
    
  //Query Method 
    @GetMapping("/pet/{pet}") 
    @Operation(summary = "Busca uma consulta por pet")
    public ResponseEntity<List<Consulta>> buscarConsultasPorPet(@PathVariable Long id_pet) { 
      List<Consulta> consultas = consultaService.buscarConsultasPorPet(id_pet); 
      return ResponseEntity.ok(consultas); 
    } 

    @GetMapping("/{id}") 
    @Operation(summary = "Busca uma consulta por id")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable Long id) { 
        Consulta consulta = consultaService.buscaConsultaId(id); 
        if (consulta != null) { 
            return ResponseEntity.ok(consulta); 
        } else { 
            return ResponseEntity.notFound().build(); 
        } 
    } 
    @GetMapping("/") 
    @Operation(summary = "Busca todas consultas")
    public ResponseEntity<List<Consulta>> getAllConsultas() { 
        List<Consulta> consultas = consultaService.buscaTodosConsultas(); 
        return ResponseEntity.ok(consultas); 
    } 

    @PostMapping("/") 
    @Operation(summary = "Cadastra uma consulta")
    public ResponseEntity<Consulta> criarConsulta(@RequestBody @Valid Consulta consulta) { 
        Consulta criarConsulta = consultaService.salvaConsulta(consulta); 
        return ResponseEntity.status(HttpStatus.CREATED).body(criarConsulta); 
    } 
    
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma consulta")
    public ResponseEntity<Consulta> updateConsulta(@PathVariable Long id, @RequestBody @Valid Consulta consulta) { 
        Consulta updatedConsulta = consultaService.alterarConsulta(id, consulta); 
        if (updatedConsulta != null) { 
            return ResponseEntity.ok(consulta); 
        } else { 
            return ResponseEntity.notFound().build(); 
        } 
    } 
    @DeleteMapping("/{id}") 
    @Operation(summary = "Deleta uma consulta")
    public ResponseEntity<Consulta> deleteConsulta(@PathVariable Long id) { 
        boolean deleted = consultaService.apagarConsulta(id); 
        if (deleted) { 
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        } else { 
            return ResponseEntity.notFound().build(); 
        } 
    }   
} 
