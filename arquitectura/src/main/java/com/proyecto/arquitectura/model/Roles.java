package com.proyecto.arquitectura.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="roles")
public class Roles implements GrantedAuthority {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name="Codigo_rol")
    private String rolCode;

    @Column(name="Descrripcion_rol")
    private String rolDescription;

    

    public Roles() {
    }    

    public Roles(String rolCode, String rolDescription) {
        this.rolCode = rolCode;
        this.rolDescription = rolDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolCode() {
        return rolCode;
    }

    public void setRolCode(String rolCode) {
        this.rolCode = rolCode;
    }

    public String getRolDescription() {
        return rolDescription;
    }

    public void setRolDescription(String rolDescription) {
        this.rolDescription = rolDescription;
    }

    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return rolCode;
    }



}
