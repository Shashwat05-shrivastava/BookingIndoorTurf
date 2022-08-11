package com.booking.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entity.RegisterTurf;
import com.booking.repository.RegisterTurfRepository;
import com.booking.services.RegisterTurfService;

@Service
public class RegisterTurfServiceImpl implements RegisterTurfService{
	
	@Autowired
	private RegisterTurfRepository registerTurfRepository;

	@Override
	public RegisterTurf addTurf(RegisterTurf rTurf) {
		return this.registerTurfRepository.save(rTurf);
	}

	@Override
	public RegisterTurf updateTurf(RegisterTurf rTurf) {
		return this.registerTurfRepository.save(rTurf);
	}

	@Override
	public Set<RegisterTurf> getTurfs() {
		return new LinkedHashSet<>(this.registerTurfRepository.findAll());
	}

	@Override
	public RegisterTurf getTurf(Long tId) {
		return this.registerTurfRepository.findById(tId).get();
	}

	@Override
	public void deleteTurf(Long tId) {
		this.registerTurfRepository.deleteById(tId);
		
	}

}
