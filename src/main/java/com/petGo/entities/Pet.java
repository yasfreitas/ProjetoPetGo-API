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
@Table(name = "pet")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "nascimento", nullable = false, length = 255)
	private String nascimento;
	
	@Column(name = "documento", nullable = false, length = 255)
	private String documento;
	
	@Column(name = "raca", nullable = false, length = 255)
	private String raca;
	
	@Column(name = "cor", nullable = false, length = 255)
	private String cor;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo", nullable = false)
	private Tipo tipo;
	
	@ManyToOne
	@JoinColumn(name = "id_proprietario", nullable = false)
	private Proprietario proprietario;

}
