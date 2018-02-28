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
import petstore.models.Owner;

/**
 *
 * @author zion
 */
@Repository
public class OwnerDao {
    @PersistenceContext
    private EntityManager entityManager;
    
    public Collection<Owner> getAllOwners() {
        Query query = entityManager.createQuery("SELECT e FROM owner e");
        return (Collection<Owner>) query.getResultList();

    }
    
    public void createOwner(Owner owner) {
        entityManager.persist(owner);
    }
}
