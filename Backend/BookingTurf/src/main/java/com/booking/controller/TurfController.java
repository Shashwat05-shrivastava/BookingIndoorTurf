package com.booking.controller;


import org.springframework.beans.factory.annotation.Autowired;
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

import com.booking.entity.Turf;
import com.booking.services.TurfService;

@RestController
@RequestMapping("/turf")
@CrossOrigin("*")
public class TurfController {
	
	@Autowired
	public TurfService turfService;
	
	//get all Turf
	@PostMapping("/")
	public ResponseEntity<Turf> addTurf(@RequestBody Turf turf){
		Turf turf1=this.turfService.addTurf(turf);
		return ResponseEntity.ok(turf1);
	}
	
	//get  Turf
	@GetMapping("/{tId}")
	public Turf getTurf(@PathVariable("tId") Long turfId) {
		return this.turfService.getTurf(turfId);
	}
	
	// get All Turf
	@GetMapping("/")
	public ResponseEntity<?> getTurfs(){
		return ResponseEntity.ok(this.turfService.getTurfs());
	}
	
	//Update Turf
	@PutMapping("/")
	public Turf updateTurf(@RequestBody Turf turf) {
		return this.turfService.updateTurf(turf);
	}
	
	//Delete turf
	@DeleteMapping("/{tId}")
	public void turfId(@PathVariable("tId") Long turfId) {
		this.turfService.deleteTurf(turfId);
	}
}
