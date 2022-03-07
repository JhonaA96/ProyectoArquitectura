package com.proyecto.arquitectura.dao;

import com.proyecto.arquitectura.model.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeUserDao extends JpaRepository<TypeUser, Long> {

}
