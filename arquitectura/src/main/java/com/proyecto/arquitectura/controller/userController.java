package com.proyecto.arquitectura.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
import com.proyecto.arquitectura.Service.UserService;
import com.proyecto.arquitectura.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("*")
public class userController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/all")
    public List<User> getAll(){
        List<User> user = StreamSupport.stream(userService.findAll().spliterator(), false).collect(Collectors.toList());
        return user;
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity <?> find(@PathVariable(value = "id") Long userId){
        Optional<User> oUser = userService .findById(userId);

        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oUser);
        }
    }
    
    @PostMapping("/guardar")
    public ResponseEntity <?> save(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
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
        oUser.get().setTypeUser(user.getTypeUser());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.save(oUser.get()));
    }

    @Transactional
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity <?> delete(@PathVariable(value = "id") Long userId){

        Optional<User> oUser = userService.findById(userId);
        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }

        userService.delete(userId);
        return ResponseEntity.ok().build();
    }
}