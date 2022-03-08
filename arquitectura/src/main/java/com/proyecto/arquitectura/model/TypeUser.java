package com.proyecto.arquitectura.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name="Tipo_Usuarios")
public class TypeUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombre;

	@OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "typeUser_id")
	private List<User> users;

	public TypeUser(String nombre) {
		this.nombre = nombre;
	}

	public TypeUser(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TypeUser [id=" + id + ", id_tipo_usuario=" +  ", nombre=" + nombre + "]";
	}
}
