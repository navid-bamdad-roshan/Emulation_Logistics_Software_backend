package com.example.els.address;

public class AddressDto {

    private Long id;

    private String country;
    private String state;
    private String city;
    private String postalCode;
    private String address;

    public AddressDto() {
        super();
    }

    public AddressDto(String country, String state, String city, String postalCode, String address) {
        super();
        this.country = country;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;

    }

    public AddressDto(Long id, String country, String state, String city, String postalCode, String address) {
        super();
        if (id != null){
            this.id = id;
        }
        this.country = country;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // @Override
    // public String toString() {
    //     return ("{\"id\":\"" + id.toString() + "\", \"address\":\"" + address + "\", \"city\":\"" + city + "\", \"country\":\"" + country + "\", \"id\":\"" + id
    //             + "\", \"postalCode\":\"" + postalCode + "\", \"state\":\"" + state + "\"}");
    // }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }



    
}
