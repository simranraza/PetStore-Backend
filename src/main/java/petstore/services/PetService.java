/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore.services;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petstore.models.Pet;
import petstore.presistence.PetDao;
import petstore.repository.PetRepository;

/**
 *
 * @author zion
 */
@Transactional
@Service
public class PetService {
   
    
    @Autowired
    PetRepository petRepository;
    
    public Collection<Pet> getAllPets() {
        return petRepository.findAll();
    }
    
    public Pet createPet(Pet pet) {
        
        Pet newPet = petRepository.save(pet);
        return newPet;
    }
    
    public Pet getPetById(long id) {
        return petRepository.findOne(id);
    }
}
