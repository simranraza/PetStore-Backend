/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore.presistence;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import petstore.models.Pet;

/**
 *
 * @author zion
 */
@Repository
public class PetDao {
    @PersistenceContext
    private EntityManager entityManager;
    
    public Collection<Pet> getAllPets() {
        Query query = entityManager.createQuery("SELECT e FROM pet e");
        return (Collection<Pet>) query.getResultList();

    }

    public void createPet(Pet pet) {
        
        entityManager.persist(pet);
    }
}
