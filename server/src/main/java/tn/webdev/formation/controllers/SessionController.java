package tn.webdev.formation.controllers;

import org.springframework.web.bind.annotation.*;
import tn.webdev.formation.dao.SessionFormationRepository;
import tn.webdev.formation.entities.Profil;
import tn.webdev.formation.entities.SessionFormation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/sessions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SessionController {
    
    @Autowired
    private SessionFormationRepository sessionFormationRepository;

    @GetMapping(value = "/")
    public List<SessionFormation> getusers(){
        return sessionFormationRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public SessionFormation getsession(@PathVariable Long id){
        return sessionFormationRepository.findById(id).orElseThrow();
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> addsession(@RequestBody SessionFormation session){
        sessionFormationRepository.save(session);
        return new ResponseEntity<>("Session added successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<String> updateFormateur(@RequestBody SessionFormation session){
        if(session.getId()==null)
            return new ResponseEntity<>("No session provided",HttpStatus.BAD_REQUEST);
        if(sessionFormationRepository.findById(session.getId())==null)
            return new ResponseEntity<>("No session with the provided id",HttpStatus.BAD_REQUEST);

        sessionFormationRepository.save(session);
        return new ResponseEntity<>("session updated successfully", HttpStatus.OK);
    }




    @DeleteMapping(value = "/")
    public ResponseEntity<String> deleteallsessions(){
        sessionFormationRepository.deleteAll();
        return new ResponseEntity<>("All sessions deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletesession(@PathVariable Long id){
        sessionFormationRepository.deleteById(id);
        return new ResponseEntity<>("Session deleted successfully", HttpStatus.OK);
    }
}
