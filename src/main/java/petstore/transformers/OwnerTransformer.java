/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore.transformers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import petstore.dtos.OwnerDto;
import petstore.models.Owner;
import petstore.services.PetService;

/**
 *
 * @author zion
 */
@Component
public class OwnerTransformer {
    @Autowired 
    PetService petService;
    
    @Autowired
    PetTransformer petTranformer;
    
    public Owner transformDto(OwnerDto ownerDto) {
        Owner owner = new Owner();
        owner.setFirst_name(ownerDto.getFirst_name());
        owner.setLast_name(ownerDto.getLast_name());
        owner.setCity(ownerDto.getCity());
        owner.setPet(petService.getPetById(ownerDto.getPet() !=null ? ownerDto.getPet().getId():-1));
        return owner;    
    }
    
    public OwnerDto transformPojo(Owner owner) {
        return transformPojo(owner, true);
    }
    public OwnerDto transformPojo(Owner owner, boolean isChild) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(owner.getId());
        ownerDto.setFirst_name(owner.getFirst_name());
        ownerDto.setLast_name(owner.getLast_name());
        ownerDto.setCity(owner.getCity());
        ownerDto.setPet(owner.getPet() != null ? petTranformer.transformPojo(owner.getPet(), true): null);
        return ownerDto;
    }
}
