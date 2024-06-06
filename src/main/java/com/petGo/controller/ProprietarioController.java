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

import com.petGo.entities.Proprietario;
import com.petGo.service.ProprietarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/proprietario") 
@Tag(name = "Proprietario", description="API REST DE GERENCIAMENTO DE PROPRIETARIOS") 
public class ProprietarioController { 

    private final ProprietarioService proprietarioService; 

    @Autowired 
    public ProprietarioController(ProprietarioService proprietarioService) { 
        this.proprietarioService = proprietarioService; 
    } 
    
    //Query Method 
    @GetMapping("/cidade/{cidade}") 
    @Operation(summary = "Busca um proprietário por cidade")
    public ResponseEntity<List<Proprietario>> buscarProprietariosPorCidade(@PathVariable String cidade) { 
      List<Proprietario> proprietarios = proprietarioService.buscarProprietariosPorCidade(cidade); 
      return ResponseEntity.ok(proprietarios); 
    } 

  //Query Method 
    @GetMapping("/nome/{nome}") 
    @Operation(summary = "Busca um proprietário por nome")
    public ResponseEntity<List<Proprietario>> buscarProprietariosPorNome(@PathVariable String nome) { 
      List<Proprietario> proprietarios = proprietarioService.buscarProprietariosPorNome(nome); 
      return ResponseEntity.ok(proprietarios); 
    } 
    
  //Query Method 
    @GetMapping("/nomeCompleto/{nomeCompleto}") 
    @Operation(summary = "Busca um proprietário por nome completo")
    public ResponseEntity<List<Proprietario>> buscarProprietariosPorNomeCompleto(@PathVariable String nomeCompleto) { 
      List<Proprietario> proprietarios = proprietarioService.buscarProprietariosPorNomeCompleto(nomeCompleto); 
      return ResponseEntity.ok(proprietarios); 
    }

    @GetMapping("/{id}") 
    @Operation(summary = "Busca um proprietario por id")
    public ResponseEntity<Proprietario> getProprietarioById(@PathVariable Long id) { 
        Proprietario proprietario = proprietarioService.getProprietarioById(id); 
        if (proprietario != null) { 
            return ResponseEntity.ok(proprietario); 
        } else { 
            return ResponseEntity.notFound().build(); 
        } 
    } 
    @GetMapping("/") 
	@Operation(summary = "Busca todos os proprietarios")
    public ResponseEntity<List<Proprietario>> getAllProprietarios() { 
        List<Proprietario> proprietarios = proprietarioService.getAllProprietarios(); 
        return ResponseEntity.ok(proprietarios); 
    } 

    @PostMapping("/") 
    @Operation(summary = "Cadastra um proprietario") 
    public ResponseEntity<Proprietario> criarProprietario(@RequestBody @Valid Proprietario proprietario) { 
        Proprietario criarProprietario = proprietarioService.salvarProprietario(proprietario); 
        return ResponseEntity.status(HttpStatus.CREATED).body(criarProprietario); 
    } 

    @PutMapping("/{id}") 
    @Operation(summary = "Atualiza um proprietario") 
    public ResponseEntity<Proprietario> updateProprietario(@PathVariable Long id, @RequestBody @Valid Proprietario proprietario) { 
        Proprietario updatedProprietario = proprietarioService.updateProprietario(id, proprietario); 
        if (updatedProprietario != null) { 
            return ResponseEntity.ok(proprietario); 
        } else { 
            return ResponseEntity.notFound().build(); 
        } 
    } 

    @DeleteMapping("/{id}") 
    @Operation(summary = "Deleta um proprietario") 
    public ResponseEntity<Proprietario> deleteProprietario(@PathVariable Long id) { 
        boolean deleted = proprietarioService.deleteProprietario(id); 
        if (deleted) { 
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        } else { 
            return ResponseEntity.notFound().build(); 
        } 
    } 
} 
