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

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import petstore.dtos.PetDto;
import petstore.models.Pet;
import petstore.services.PetService;

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
    
    @RequestMapping(value = "/pets",method = RequestMethod.GET)
    public List<PetDto> getAllPets() {
        List<PetDto> pets = new ArrayList<>();
        pets = new ArrayList(petService.getAllPets());
        return pets;
    }
    
    @RequestMapping(value = "/pet",method = RequestMethod.POST)
    public void createPet(@RequestBody PetDto petDto) throws ParseException {
        System.out.println(petDto);
        Pet pet = this.transformDto(petDto);
        petService.createPet(pet);
    }
    
    private Pet transformDto(PetDto petDto) throws ParseException {
        Pet pet = new Pet();
        //DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MM-yyyy");

        pet.setBirthday(new SimpleDateFormat("d-MM-yyyy").parse(petDto.getBirthday()));
        pet.setName(petDto.getName());
       
        return pet;
    }
}
