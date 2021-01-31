package com.example.els.Customer;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
    
    public Customer() {
        super();
    }

    public Customer(Long id, String firstName, String lastName, String email, String phone, List<Address> addresses) {
        super();
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.phone = phone;
        this.addresses = addresses;
    }

    public Customer(String firstName, String lastName, String email, String phone, List<Address> addresses) {
        super();
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.phone = phone;
        this.addresses = addresses;
    }
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="customer_id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String LastName;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;
    
    //@OneToMany(mappedBy = "customer", targetEntity = Address.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;



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
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "{\n"+"id=" + id + ", \nFirst Name=" + firstName + ", \nLast Name=" + LastName + ", \nphone=" + phone + ", \nemail=" + email  + ", \naddresses=" + addresses.toString() + "}" ;
    }



    
}
