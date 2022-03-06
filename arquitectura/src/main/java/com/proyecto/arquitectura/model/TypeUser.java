package com.proyecto.arquitectura.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="Tipo_Usuarios")
public class TypeUser {
	
	@Id
	private Long Id;

	@Column
	private String nombre;
	
}
