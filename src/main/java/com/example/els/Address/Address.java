package com.example.els.Address;

import com.example.els.Customer.Customer;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="addresses")
public class Address {



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;

    private String country;
    private String state;
    private String city;
    private String postalCode;
    private String address;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Address() {
        super();
    }

    public Address(String country, String state, String city, String postalCode, String address, Customer customer) {
        super();
        this.country = country;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.customer = customer;

    }

    public Address(Long id, String country, String state, String city, String postalCode, String address, Customer customer) {
        super();
        if (id != null){
            this.id = id;
        }
        this.country = country;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.customer = customer;

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

    @Override
    public String toString() {
        return ("{\"id\":\"" + id.toString() + "\", \"address\":\"" + address + "\", \"city\":\"" + city + "\", \"country\":\"" + country + "\", \"id\":\"" + id
                + "\", \"postalCode\":\"" + postalCode + "\", \"state\":\"" + state + "\"}");
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
}
