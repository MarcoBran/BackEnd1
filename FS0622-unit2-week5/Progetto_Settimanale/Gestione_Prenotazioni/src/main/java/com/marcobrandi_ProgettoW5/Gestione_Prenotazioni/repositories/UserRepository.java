package com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcobrandi_ProgettoW5.Gestione_Prenotazioni.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
