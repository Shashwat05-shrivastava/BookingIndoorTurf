package com.booking.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.booking.entity.RegisterTurf;

@Service
public interface RegisterTurfService {
    public RegisterTurf addTurf(RegisterTurf rTurf);
	
	public RegisterTurf updateTurf(RegisterTurf rTurf);
	
	public Set<RegisterTurf> getTurfs();
	
	public RegisterTurf getTurf(Long tId);
	
	public void deleteTurf(Long tId);
}
