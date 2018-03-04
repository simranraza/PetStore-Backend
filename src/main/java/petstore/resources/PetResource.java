/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore.resources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import petstore.dtos.PetDto;
import petstore.models.Pet;
import petstore.services.OwnerService;
import petstore.services.PetService;
import petstore.transformers.PetTransformer;

/**
 *
 * @author zion
 */
@RestController
@Produces(MediaType.APPLICATION_JSON)
@EnableAutoConfiguration
public class PetResource {
    
    @Autowired
    PetService petService;
    
    @Autowired
    OwnerService ownerService;
    
    @Autowired
    PetTransformer petTransformer;
    
    @CrossOrigin
    @RequestMapping(value = "/pets",method = RequestMethod.GET)
    public ResponseEntity<List<PetDto>> getAllPets() {
        List<PetDto> petsDtos = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        pets = new ArrayList(petService.getAllPets());
        
        for(Pet pet : pets) {
            petsDtos.add(petTransformer.transformPojo(pet, false));
        }
        return new ResponseEntity<>(petsDtos,HttpStatus.OK ) ;
    }
    
    @RequestMapping(value = "/pet",method = RequestMethod.POST)
    public ResponseEntity<String> createPet(@RequestBody PetDto petDto) throws ParseException {
        System.out.println(petDto);
        Pet pet = petTransformer.transformDto(petDto);
        petService.createPet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
