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
public class OwnerDto {
    private long id;
    private String first_name;
    private String last_name;
    private String city;
    private long pet_id;

    public OwnerDto(){
        
    }
    public OwnerDto(long id, String first_name, String last_name, String city, long pet_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.pet_id = pet_id;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getPet_id() {
        return pet_id;
    }

    public void setPet_id(long pet_id) {
        this.pet_id = pet_id;
    }
    
}
