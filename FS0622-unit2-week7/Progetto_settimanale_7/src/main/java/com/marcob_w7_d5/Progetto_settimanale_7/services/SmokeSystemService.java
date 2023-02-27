package com.marcob_w7_d5.Progetto_settimanale_7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.marcob_w7_d5.Progetto_settimanale_7.models.SmokeSystem;
import com.marcob_w7_d5.Progetto_settimanale_7.repositories.SmokeSystemRepo;

@Service
public class SmokeSystemService {
	
	@Autowired
	private SmokeSystemRepo sr;
	
	public void save(SmokeSystem s) {
		sr.save(s);
	}
}
