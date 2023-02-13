package com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.User;
import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository ur;
	
	public void addUser(User u) {
		ur.save(u);
	}
	
	public List<User> getAll(){
		return ur.findAll();	
	}
	
	public User findUserById(Long id){
        return ur.findById(id).isPresent() ? ur.findById(id).get() : null;
    }
}
