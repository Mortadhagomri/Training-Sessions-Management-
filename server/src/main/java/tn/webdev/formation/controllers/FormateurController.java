package tn.webdev.formation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.webdev.formation.dao.FormateurRepository;
import tn.webdev.formation.entities.Domaine;
import tn.webdev.formation.entities.Formateur;

@RestController
@RequestMapping("/formateurs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FormateurController {
    
    @Autowired
    private FormateurRepository formateurRepository;

    @GetMapping(value = "/")
    public List<Formateur> getformateurs(){
        return formateurRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Formateur getAformateur(@PathVariable Long id){
        return formateurRepository.findById(id).orElseThrow();
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> addFormateur(@RequestBody Formateur formateur){
        formateurRepository.save(formateur);
        return new ResponseEntity<>("Formateur added successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<String> updateFormateur(@RequestBody Formateur formateur){
        if(formateur.getId()==null)
            return new ResponseEntity<>("No formateur provided",HttpStatus.BAD_REQUEST);
        if(formateurRepository.findById(formateur.getId())==null)
            return new ResponseEntity<>("No formateur with the provided id",HttpStatus.BAD_REQUEST);

        formateurRepository.save(formateur);
        return new ResponseEntity<>("formateur updated successfully", HttpStatus.OK);
    }



    @DeleteMapping(value = "/")
    public ResponseEntity<String> deleteallformateur(){
        formateurRepository.deleteAll();
        return new ResponseEntity<>("All formateurs deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteauformateur(@PathVariable Long id){
        formateurRepository.deleteById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
