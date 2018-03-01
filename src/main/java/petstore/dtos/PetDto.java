/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zion
 */
public class PetDto extends BaseDto{
    
    private String name;
    private String birthday;
    private OwnerDto owner;
    
    public PetDto(){
        
    }

    public PetDto(long id, String name, String birthday, OwnerDto owner) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.owner = owner;
    }
    
    

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public OwnerDto getOwner() {
        return owner;
    }

    public void setOwner(OwnerDto owner) {
        this.owner = owner;
    }
    
    
}
