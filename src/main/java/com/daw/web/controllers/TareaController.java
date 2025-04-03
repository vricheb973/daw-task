package com.daw.web.controllers;

import java.util.List;

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

import com.daw.persistence.entities.Tarea;
import com.daw.services.TareaService;

@RestController
@RequestMapping("/tareas")
public class TareaController {
	
	@Autowired
	private TareaService tareaService;
	
	@GetMapping
	public ResponseEntity<List<Tarea>>  list() {
		return ResponseEntity.status(HttpStatus.OK).body(this.tareaService.findAll());
	}
	
	@GetMapping("/{idTarea}")
	public ResponseEntity<Tarea> findById(@PathVariable int idTarea) {
		return ResponseEntity.ok(this.tareaService.findById(idTarea));
	}
	
	@DeleteMapping("/{idTarea}")
	public ResponseEntity<?> delete(@PathVariable int idTarea) {
		if(this.tareaService.deleteById(idTarea)) {
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El ID indicado no existe");
		}
	}
	
	@PostMapping
	public ResponseEntity<Tarea> create(@RequestBody Tarea tarea) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.tareaService.create(tarea));
	}
	
	@PutMapping("/{idTarea}")
	public ResponseEntity<Tarea> update(@PathVariable int idTarea, @RequestBody Tarea tarea) {
		return ResponseEntity.ok(this.tareaService.update(tarea));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
