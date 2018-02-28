/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petstore.models.Pet;

/**
 *
 * @author zion
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
    
}
