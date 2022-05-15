package com.proyecto.arquitectura.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.proyecto.arquitectura.Service.TypeUserService;
import com.proyecto.arquitectura.model.TypeUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/tipoUsuario")
@CrossOrigin("*")
public class typeUserController {
    
    @Autowired
    private TypeUserService typeUserService;
    
    @PostMapping("/save")
    public ResponseEntity <?> create(@RequestBody TypeUser typeUser){

        return ResponseEntity.status(HttpStatus.CREATED).body(typeUserService.save(typeUser));
    }

    @GetMapping("/getUserType/{id}")
    public ResponseEntity <?> read(@PathVariable(value = "id") Long typeUserId){
        Optional<TypeUser> oTypeUser = typeUserService .findById(typeUserId);

        if(!oTypeUser.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oTypeUser);
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity <?> update(@PathVariable(value = "id") Long typeUserId, @RequestBody TypeUser typeUser){

        Optional<TypeUser> oTypeUser = typeUserService.findById(typeUserId);
        if(!oTypeUser.isPresent()){
            return ResponseEntity.notFound().build();
        }

        oTypeUser.get().setNombre(typeUser.getNombre());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(typeUserService.save(oTypeUser.get()));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity <?> delete(@PathVariable(value = "id") Long typeUserId){

        Optional<TypeUser> oUser = typeUserService.findById(typeUserId);
        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }

        typeUserService.delete(typeUserId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/getAll")
    public List<TypeUser> readAll(){
        List<TypeUser> typeUser = StreamSupport.stream(typeUserService.findAll().spliterator(), false).collect(Collectors.toList());
        return typeUser;
    }
}