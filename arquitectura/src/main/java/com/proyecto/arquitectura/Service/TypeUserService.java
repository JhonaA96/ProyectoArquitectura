package com.proyecto.arquitectura.Service;

import java.util.Optional;

import com.proyecto.arquitectura.model.TypeUser;

import org.springframework.stereotype.Service;

@Service
public interface TypeUserService {

    public Iterable<TypeUser> findAll();
    public Optional<TypeUser> findById(Long Id);
    public TypeUser save(TypeUser typeUser);
    public void delete(Long Id);
    
}
