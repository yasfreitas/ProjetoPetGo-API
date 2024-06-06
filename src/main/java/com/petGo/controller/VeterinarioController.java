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

import com.petGo.entities.Veterinario;
import com.petGo.service.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/veterinario")
@Tag(name = "Veterinário", description="API REST DE GERENCIAMENTO DE VETERINÁRIO") 
public class VeterinarioController {
    private final VeterinarioService veterinarioService; 
    
    @Autowired 
    public VeterinarioController(VeterinarioService veterinarioService) { 
        this.veterinarioService = veterinarioService; 
    } 

    //Query Method 
    @GetMapping("/cidade/{cidade}") 
    @Operation(summary = "Busca um veterinário por cidade")
    public ResponseEntity<List<Veterinario>> buscarVeterinariosPorCidade(@PathVariable String cidade) { 
      List<Veterinario> veterinarios = veterinarioService.buscarVeterinariosPorCidade(cidade); 
      return ResponseEntity.ok(veterinarios); 
    } 

  //Query Method 
    @GetMapping("/nome/{nome}") 
    @Operation(summary = "Busca um veterinário por nome")
    public ResponseEntity<List<Veterinario>> buscarVeterinariosPorNome(@PathVariable String nome) { 
      List<Veterinario> veterinarios = veterinarioService.buscarVeterinariosPorNome(nome); 
      return ResponseEntity.ok(veterinarios); 
    } 
    
  //Query Method 
    @GetMapping("/especialidade/{especialidade}") 
    @Operation(summary = "Busca um veterinário por especialidade")
    public ResponseEntity<List<Veterinario>> buscarVeterinariosPorEspecialidade(@PathVariable Long especialidade) { 
      List<Veterinario> veterinarios = veterinarioService.buscarVeterinariosPorEspecialidade(especialidade); 
      return ResponseEntity.ok(veterinarios); 
    } 

    @GetMapping("/{id}") 
    @Operation(summary = "Busca um veterinário por id")
    public ResponseEntity<Veterinario> getVeterinarioById(@PathVariable Long id) { 
        Veterinario veterinario = veterinarioService.getVeterinarioById(id); 
        if (veterinario != null) { 
            return ResponseEntity.ok(veterinario); 
        } else { 
            return ResponseEntity.notFound().build(); 
        } 
    } 
    @GetMapping("/") 
	@Operation(summary = "Busca todos os veterinários")
    public ResponseEntity<List<Veterinario>> getAllVeterinarios() { 
        List<Veterinario> veterinarios = veterinarioService.getAllVeterinarios(); 
        return ResponseEntity.ok(veterinarios); 
    } 

    @PostMapping("/")
    @Operation(summary = "Cadastra um veterinário")
    public ResponseEntity<Veterinario> criarVeterinario(@RequestBody @Valid Veterinario veterinario) { 
        Veterinario criarVeterinario = veterinarioService.salvarVeterinario(veterinario); 
        return ResponseEntity.status(HttpStatus.CREATED).body(criarVeterinario); 
    } 

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um veterinário") 
    public ResponseEntity<Veterinario> updateVeterinario(@PathVariable Long id, @RequestBody @Valid Veterinario veterinario) { 
        Veterinario updatedVeterinario = veterinarioService.updateVeterinario(id, veterinario); 
        
        if (updatedVeterinario != null) { 
            return ResponseEntity.ok(veterinario); 
        } else { 
            return ResponseEntity.notFound().build(); 
        } 
    } 

    @DeleteMapping("/{id}") 
    @Operation(summary = "Apaga um veterinário") 
    public ResponseEntity<Veterinario> deleteVeterinario(@PathVariable Long id) { 
        boolean deleted = veterinarioService.deleteVeterinario(id); 
        if (deleted) { 
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        } else { 
            return ResponseEntity.notFound().build(); 
        } 
    } 
} 
