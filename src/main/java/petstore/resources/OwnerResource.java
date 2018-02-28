/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import petstore.dtos.OwnerDto;
import petstore.models.Owner;
import petstore.services.OwnerService;

/**
 *
 * @author zion
 */
@RestController
@Produces(MediaType.APPLICATION_JSON)
public class OwnerResource {
    @Autowired
    OwnerService ownerService;
    
    @RequestMapping(value = "/owners",method = RequestMethod.GET)
    public ResponseEntity<List<OwnerDto>> getAllOwners() {
        List<OwnerDto> owners = new ArrayList<>();
        
        owners = new ArrayList(ownerService.getAllOwners());
        return new ResponseEntity<List<OwnerDto>>(owners, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/owners",method = RequestMethod.POST)
    public ResponseEntity<String> createOwner(@RequestBody OwnerDto ownerDto) {
        System.out.println(ownerDto);
        ownerService.createOwner(this.transformDto(ownerDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
    
    private Owner transformDto(OwnerDto ownerDto) {
        Owner owner = new Owner();
        owner.setFirst_name(ownerDto.getFirst_name());
        owner.setLast_name(ownerDto.getLast_name());
        owner.setCity(ownerDto.getCity());
        owner.setPet(null);
        return owner;    
    }
}
