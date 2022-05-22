package com.proyecto.arquitectura.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;
import com.proyecto.arquitectura.Service.JuegosService;
import com.proyecto.arquitectura.model.Juegos;
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
@RequestMapping("/juegos")
@CrossOrigin("*")
public class juegosController {

    @Autowired
    private JuegosService juegoService;

    @GetMapping("/all")
    public List<Juegos> getAll(){
        List <Juegos> juegos = StreamSupport.stream(juegoService.findAll().spliterator(), false).collect(Collectors.toList());
        return juegos;
    }

    @GetMapping("juego/{id}")
    public ResponseEntity <?> find(@PathVariable(value="id") Long juegoId){
        Optional<Juegos> oJuego = juegoService.findById(juegoId);

        if(!oJuego.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oJuego);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity <?> save(@RequestBody Juegos juego){
        return ResponseEntity.status(HttpStatus.CREATED).body(juegoService.save(juego));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity <?> update(@PathVariable(value = "id") Long juegoId, @RequestBody Juegos juego){

        Optional<Juegos> oJuego = juegoService.findById(juegoId);
        if(!oJuego.isPresent()){
            return ResponseEntity.notFound().build();
        }

        oJuego.get().setNombre(juego.getNombre());
        oJuego.get().setClasificacion(juego.getClasificacion());
        oJuego.get().setDesarrollador(juego.getDesarrollador());
        oJuego.get().setFechaCreacion(juego.getFechaCreacion());
        oJuego.get().setGenero(juego.getGenero());
        oJuego.get().setModos(juego.getModos());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(juegoService.save(oJuego.get()));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity <?> delete(@PathVariable(value = "id") Long juegoId){
        Optional<Juegos> oJuego = juegoService.findById(juegoId);

        if(!oJuego.isPresent()){
            return ResponseEntity.notFound().build();
        }

        juegoService.delete(juegoId);
        return ResponseEntity.ok().build();
    }
    
}
