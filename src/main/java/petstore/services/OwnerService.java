/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore.services;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petstore.models.Owner;
import petstore.presistence.OwnerDao;
import petstore.repository.OwnerRepository;

/**
 *
 * @author zion
 */
@Transactional
@Service
public class OwnerService {
    
    @Autowired
    OwnerRepository ownerRepository;
    
    public Collection<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
    
    public Owner createOwner(Owner owner) {
        Owner newOwner = ownerRepository.save(owner);
        return newOwner;
    }
    
    public Owner getOwnerById(long id) {
        
        return ownerRepository.findOne(id);
    }
}
