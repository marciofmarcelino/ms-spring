package com.marciofm.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marciofm.hrworker.entities.Worker;
import com.marciofm.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "workers")
public class WorkerResource {

	
	
	@Autowired
	private WorkerService service;

	@GetMapping
	public  ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){

		Worker obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
