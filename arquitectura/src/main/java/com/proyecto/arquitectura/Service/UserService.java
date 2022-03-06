package com.proyecto.arquitectura.Service;

import java.util.Optional;

import com.proyecto.arquitectura.model.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public Iterable<User> findAll();
    public Optional<User> findById(Long Id);
    public User save(User user);
    public void delete(Long Id);
    
}
