/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore.transformers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import petstore.dtos.OwnerDto;
import petstore.dtos.PetDto;
import petstore.models.Owner;
import petstore.models.Pet;
import petstore.services.OwnerService;

/**
 *
 * @author zion
 */
@Component
public class PetTransformer {
    @Autowired 
    OwnerService ownerService;
    
    @Autowired 
    OwnerTransformer ownerTransformer;
    public Pet transformDto(PetDto petDto) throws ParseException {
        Pet pet = new Pet();
        //DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MM-yyyy");

        pet.setBirthday(new SimpleDateFormat("d-MM-yyyy").parse(petDto.getBirthday()));
        pet.setName(petDto.getName());
        if (petDto.getOwner() == null)
            pet.setOwner(null);
        else {
            if (petDto.getOwner().getId() != 0L)
                pet.setOwner(ownerService.getOwnerById(petDto.getOwner().getId()));
            else
                pet.setOwner(ownerTransformer.transformDto(petDto.getOwner()));
        }
        return pet;
    }
    public PetDto transformPojo (Pet pet) {
        return transformPojo(pet, true);
    }
    public PetDto transformPojo (Pet pet, boolean isChild) {
        PetDto petDto = new PetDto();
        petDto.setId(pet.getId());
        petDto.setName(pet.getName());
        petDto.setBirthday(pet.getBirthday() != null ? pet.getBirthday().toLocaleString(): null);
        if (isChild)
            petDto.setOwner(null);
        else { 
            if (pet.getOwner() != null) {
                OwnerDto tempOwner = this.ownerTransformer.transformPojo(pet.getOwner());
                petDto.setOwner(tempOwner);
            }
        }   
        return petDto;
    }
}
