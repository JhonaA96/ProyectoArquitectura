package com.proyecto.arquitectura.Service;

import java.util.Optional;

import com.proyecto.arquitectura.dao.JuegosDao;
import com.proyecto.arquitectura.model.Juegos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JuegosServiceImpl implements JuegosService {
    
    @Autowired
    private JuegosDao juegosDao;

    @Override
    public Iterable<Juegos> findAll(){
        return juegosDao.findAll();
    }

    @Override
    public Optional<Juegos> findById(Long id){
        return juegosDao.findById(id);
    }

    @Override
    public Juegos save(Juegos juego){
        return juegosDao.save(juego);
    }

    @Override
    public void delete (Long id){
        juegosDao.deleteById(id);
    }
}
