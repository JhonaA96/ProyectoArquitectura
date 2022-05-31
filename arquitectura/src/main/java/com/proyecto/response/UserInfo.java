package com.proyecto.response;

public class UserInfo {
    
    private String nombres;
	private String userName;
	
	private Object roles;

	public String getNombres() {
		return nombres;
	}

    public void setNombres(String nombres){
        this.nombres = nombres;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Object getRoles() {
		return roles;
	}

	public void setRoles(Object roles) {
		this.roles = roles;
	} 
}
