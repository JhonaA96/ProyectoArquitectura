package com.proyecto.arquitectura.Service;

import java.util.Optional;

import com.proyecto.arquitectura.dao.TypeUserDao;
import com.proyecto.arquitectura.model.TypeUser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TypeUserServiceImpl implements TypeUserService{
    
    //Acá vamos a hacer uso de todo el JPA para acceder a la DB
    @Autowired
    private TypeUserDao typeUserDao;


    //Select * from usuarios
    @Override
    public Iterable<TypeUser> findAll(){
        return typeUserDao.findAll();
    }

    //Select * from usuarios where id = ?
    @Override
    public Optional<TypeUser> findById(Long Id){
        return typeUserDao.findById(Id);
    }

    //insert into usuarios (?, ?, ?) values (?, ?, ?) 
    @Override
    public TypeUser save(TypeUser typeUser){
        return typeUserDao.save(typeUser);
    }

    //delete from usuarios where id = ?
    @Override
    public void delete(Long Id){
        typeUserDao.deleteById(Id);
    }
}
