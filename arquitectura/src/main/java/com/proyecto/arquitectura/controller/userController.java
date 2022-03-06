package com.proyecto.arquitectura.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.proyecto.arquitectura.Service.UserService;
import com.proyecto.arquitectura.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarios")
public class userController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/guardar")
    public ResponseEntity <?> create(@RequestBody User user){

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity <?> read(@PathVariable(value = "id") Long userId){
        Optional<User> oUser = userService .findById(userId);

        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oUser);
        }
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity <?> update(@PathVariable(value = "id") Long userId, @RequestBody User user){

        Optional<User> oUser = userService.findById(userId);
        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }

        oUser.get().setNombres(user.getNombres());
        oUser.get().setCorreo_electronico(user.getCorreo_electronico());
        oUser.get().setPassword(user.getPassword());
        oUser.get().setNumero_telefono(user.getNumero_telefono());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.save(oUser.get()));
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity <?> delete(@PathVariable(value = "id") Long userId){

        Optional<User> oUser = userService.findById(userId);
        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }

        userService.delete(userId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/listar")
    public List<User> readAll(){
        List<User> user = StreamSupport.stream(userService.findAll().spliterator(), false).collect(Collectors.toList());
        return user;
    }
}