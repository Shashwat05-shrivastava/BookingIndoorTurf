package com.booking.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entity.Turf;
import com.booking.repository.TurfRepository;
import com.booking.services.TurfService;

@Service
public class TurfServiceImpl implements TurfService{

	@Autowired
	private TurfRepository turfRepository;
	
	@Override
	public Turf addTurf(Turf turf) {
		return this.turfRepository.save(turf);
	}

	@Override
	public Turf updateTurf(Turf turf) {
		return this.turfRepository.save(turf);
	}

	@Override
	public Set<Turf> getTurfs() {
		return new LinkedHashSet<>(this.turfRepository.findAll());
	}

	@Override
	public Turf getTurf(Long tId) {
		return this.turfRepository.findById(tId).get();
	}

	@Override
	public void deleteTurf(Long tId) {
		this.turfRepository.deleteById(tId);
	}
	
}
