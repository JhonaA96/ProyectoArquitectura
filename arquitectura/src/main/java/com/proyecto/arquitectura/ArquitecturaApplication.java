package com.proyecto.arquitectura;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import com.proyecto.arquitectura.dao.TypeUserDao;
import com.proyecto.arquitectura.dao.UserDao;
import com.proyecto.arquitectura.model.Roles;
import com.proyecto.arquitectura.model.TypeUser;
import com.proyecto.arquitectura.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class ArquitecturaApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDao userDao;

	@Autowired
	private TypeUserDao typeUserDao;

	public static void main(String[] args) {
		SpringApplication.run(ArquitecturaApplication.class, args);
	}

	@PostConstruct
	public void init(){

		List<Roles> rolList = new ArrayList<>();
		rolList.add(crearRole("User", "User role"));
		rolList.add(crearRole("Admin", "Admin role"));


		if(typeUserDao.count() == 0){
			TypeUser typeUser1 = new TypeUser();
			typeUser1.setNombre("Medico");
			typeUserDao.save(typeUser1);
	
			TypeUser typeUser2 = new TypeUser();
			typeUser2.setNombre("Paciente");
			typeUserDao.save(typeUser2);
		}

		if(userDao.count() == 0){
			User user = new User();
			user.setActive(true);
			user.setCorreo_electronico("");
			user.setNombres("Usuario Inicial");
			user.setUsuario("usuario");
			user.setNumero_telefono(1234567L);
			user.setPassword(passwordEncoder.encode("Test1234"));
			userDao.save(user);
		}
	}

	public Roles crearRole(String rolCode, String rolDescription){
		Roles rol = new Roles();
		rol.setRolCode(rolCode);
		rol.setRolDescription(rolDescription);

		return rol;
	}

}
