package com.proyecto.arquitectura.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="users")
public class User {
	
	@Id
	private Long id;
	
	@Column
	private String nombres;

	@Column
	private String usuario;
	
	@Column
	private String correo_electronico;
	
    @Column
    private String password;
    
    @Column
    private String numero_telefono;

	public User(String nombres, String usuario, String correo_electronico, String password, String numero_telefono) {
		this.nombres = nombres;
		this.usuario = usuario;
		this.correo_electronico = correo_electronico;
		this.password = password;
		this.numero_telefono = numero_telefono;
	}

	public User(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumero_telefono() {
		return numero_telefono;
	}

	public void setNumero_telefono(String numero_telefono) {
		this.numero_telefono = numero_telefono;
	}

	@Override
	public String toString() {
		return "User [correo_electronico=" + correo_electronico + ", id=" + id + ", nombres=" + nombres
				+ ", numero_telefono=" + numero_telefono + ", password=" + password + ", usuario=" + usuario + "]";
	}

	
	 
}
