package com.proyecto.arquitectura.dao;


import com.proyecto.arquitectura.model.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegosDao extends JpaRepository<Juegos, Long> {

}
