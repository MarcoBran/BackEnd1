package com.marcob_w7_d5.Progetto_settimanale_7.controller;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcob_w7_d5.Progetto_settimanale_7.models.Control;
import com.marcob_w7_d5.Progetto_settimanale_7.models.SmokeSystem;
import com.marcob_w7_d5.Progetto_settimanale_7.services.ControlService;



@RestController
@RequestMapping("/api")
public class AppController {
@Autowired
ControlService cs;

@GetMapping(path = "/control/{id}")
public ResponseEntity<Control> findById(@PathVariable(required = true) int id) {
Optional<Control> find = cs.getById(id);

    if (find.isPresent()) {
        return new ResponseEntity<>(find.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
@GetMapping(path = "/control/{id}/sys")
public ResponseEntity<Set<SmokeSystem>> findSys(@PathVariable(required = true) int id) throws Exception {
Optional<Set<SmokeSystem>> findAll = Optional.of(cs.getAllSys(id));

    if (findAll.isPresent()) {
        return new ResponseEntity<>(findAll.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
@GetMapping(path = "/control/{id}/allert")
public ResponseEntity<Set<SmokeSystem>> getAllert(@PathVariable(required = true) int id) throws Exception {
Optional<Set<SmokeSystem>> findAll = Optional.of(cs.getAllert(id));

    if (findAll.isPresent()) {
        return new ResponseEntity<>(findAll.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}

}
