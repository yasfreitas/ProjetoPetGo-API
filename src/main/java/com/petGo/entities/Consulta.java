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
@Table(name = "consulta")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@Column(name = "data", nullable = false, length = 255)
	private String data;
	
	@Column(name = "hora", nullable = false, length = 255)
	private String hora;
	
	@Column(name = "descricao", nullable = false, length = 255)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_veterinario", nullable = false)
	private Veterinario veterinario;
	
	@ManyToOne
	@JoinColumn(name = "id_pet", nullable = false)
	private Pet pet;
	
	

}
