package com.proyecto.arquitectura.seed;

import com.proyecto.arquitectura.dao.TypeUserDao;
import com.proyecto.arquitectura.model.TypeUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class TypeUserSeed implements ApplicationRunner {

    @Autowired
    TypeUserDao typeUserDao;

    public TypeUserSeed(TypeUserDao typeUserDao){
        this.typeUserDao = typeUserDao;
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception{
        if(typeUserDao.count() == 0){
            TypeUser typeUser1 = new TypeUser("Medico");
            TypeUser typeUser2 = new TypeUser("Paciente");
            typeUserDao.save(typeUser1);
            typeUserDao.save(typeUser2);
        }
    }
}
