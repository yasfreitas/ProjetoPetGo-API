package com.petGo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veterinario")
public class Veterinario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "cpf", nullable = false, length = 255)
	private String cpf;
	
	@Column(name = "telefone1", nullable = false, length = 255)
	private String telefone1;
	
	@Column(name = "telefone2", nullable = false, length = 255)
	private String telefone2;
	
	@Column(name = "rua", nullable = false, length = 255)
	private String rua;
	
	@Column(name = "numero", nullable = false, length = 255)
	private String numero;
	
	@Column(name = "cidade", nullable = false, length = 255)
	private String cidade;
	
	@Column(name = "crmv", nullable = false, length = 255)
	private String crmv;
	
	@ManyToOne
	@JoinColumn(name = "id_especilidade", nullable = false)
	private Especialidade especialidade;

}
