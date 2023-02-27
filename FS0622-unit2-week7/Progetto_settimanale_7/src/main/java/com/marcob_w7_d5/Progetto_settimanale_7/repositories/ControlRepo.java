package com.marcob_w7_d5.Progetto_settimanale_7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcob_w7_d5.Progetto_settimanale_7.models.Control;

@Repository
public interface ControlRepo extends JpaRepository<Control, Integer>{

}
