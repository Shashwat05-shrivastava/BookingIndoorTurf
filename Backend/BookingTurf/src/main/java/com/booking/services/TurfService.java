package com.booking.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.booking.entity.Turf;

@Service
public interface TurfService {
	
	public Turf addTurf(Turf turf);
	
	public Turf updateTurf(Turf turf);
	
	public Set<Turf> getTurfs();
	
	public Turf getTurf(Long tId);
	
	public void deleteTurf(Long tId);
	
}
