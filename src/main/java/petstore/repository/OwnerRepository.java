/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petstore.models.Owner;

/**
 *
 * @author zion
 */
public interface OwnerRepository extends JpaRepository<Owner, Long>{
    
}
