package com.proyecto.arquitectura.dao;

import com.proyecto.arquitectura.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserDao extends JpaRepository<User, Long> {
    public Optional<User> findByUsuario(String user);
}