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

import com.booking.entity.RegisterTurf;
import com.booking.services.RegisterTurfService;


@RestController
@RequestMapping("/registerturf")
@CrossOrigin("*")
public class RegisterTurfController {
	@Autowired
	public RegisterTurfService registerTurfService;
	
	//get all Turf
		@PostMapping("/")
		public ResponseEntity<RegisterTurf> addTurf(@RequestBody RegisterTurf rTurf){
			RegisterTurf turf1=this.registerTurfService.addTurf(rTurf);
			return ResponseEntity.ok(turf1);
		}
		
		//get  Turf
		@GetMapping("/{tId}")
		public RegisterTurf getTurf(@PathVariable("tId") Long turfId) {
			return this.registerTurfService.getTurf(turfId);
		}
		
		// get All Turf
		@GetMapping("/")
		public ResponseEntity<?> getTurfs(){
			return ResponseEntity.ok(this.registerTurfService.getTurfs());
		}
		
		//Update Turf
		@PutMapping("/")
		public RegisterTurf updateTurf(@RequestBody RegisterTurf rTurf) {
			return this.registerTurfService.updateTurf(rTurf);
		}
		
		//Delete turf
		@DeleteMapping("/{tId}")
		public void turfId(@PathVariable("tId") Long turfId) {
			this.registerTurfService.deleteTurf(turfId);
		}

}
