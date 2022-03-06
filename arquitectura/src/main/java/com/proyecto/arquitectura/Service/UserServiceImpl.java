package com.proyecto.arquitectura.Service;

import java.util.Optional;

import com.proyecto.arquitectura.dao.UserDao;
import com.proyecto.arquitectura.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    //Acá vamos a hacer uso de todo el JPA para acceder a la DB
    @Autowired
    private UserDao userDao;


    //Select * from usuarios
    @Override
    public Iterable<User> findAll(){
        return userDao.findAll();
    }

    //Select * from usuarios where id = ?
    @Override
    public Optional<User> findById(Long Id){
        return userDao.findById(Id);
    }

    //insert into usuarios (?, ?, ?) values (?, ?, ?) 
    @Override
    public User save(User user){
        return userDao.save(user);
    }

    //delete from usuarios where id = ?
    @Override
    public void delete(Long Id){
        userDao.deleteById(Id);
    }
}
