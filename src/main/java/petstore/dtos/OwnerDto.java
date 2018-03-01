/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore.dtos;

/**
 *
 * @author zion
 */
public class OwnerDto extends BaseDto{
    
    private String first_name;
    private String last_name;
    private String city;
    private PetDto pet;

    public OwnerDto(){
        
    }

    public OwnerDto(long id, String first_name, String last_name, String city, PetDto pet) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.pet = pet;
    }

    
    
  

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PetDto getPet() {
        return pet;
    }

    public void setPet(PetDto pet) {
        this.pet = pet;
    }

    
    
}
