package com.example.els.customer;

import java.util.List;

import com.example.els.address.AddressDto;

public class CustomerDto {

    public CustomerDto() {
        super();
    }

    public CustomerDto(Long id, String firstName, String lastName, String email, String phone, List<AddressDto> addresses) {
        super();
        if (id != null){
            this.id = id;
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.addresses = addresses;
    }

    public CustomerDto(String firstName, String lastName, String email, String phone, List<AddressDto> addresses) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.addresses = addresses;
    }

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
    
    private List<AddressDto> addresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDto> addresses) {
        this.addresses = addresses;
    }

}
