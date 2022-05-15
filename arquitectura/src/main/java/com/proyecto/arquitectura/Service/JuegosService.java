package com.proyecto.arquitectura.Service;

import java.util.Optional;
import com.proyecto.arquitectura.model.Juegos;
import org.springframework.stereotype.Service;


@Service
public interface JuegosService {

    public Iterable<Juegos> findAll();
    public Optional<Juegos> findById(Long id);
    public Juegos save(Juegos juego);
    public void delete(Long id);
}
