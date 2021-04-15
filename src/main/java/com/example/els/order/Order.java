package com.example.els.order;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.els.customer.Customer;
import com.example.els.shipment.Shipment;
import com.example.els.shipmentpackage.Package;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Customer sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Customer receiver;

    @Column
    private String description;

    @OneToMany(mappedBy = "order")
    private List<Package> packages;

    @ManyToMany(mappedBy = "orders")
    private List<Shipment> shipments;

    public Order() {
        super();
    }

    public Order(Customer sender, Customer receiver, String description, List<Package> packages, List<Shipment> shipments) {
        super();
        this.sender = sender;
        this.receiver = receiver;
        this.description = description;
        this.packages = packages;
        this.shipments = shipments;
    }

    public Order(Long id, Customer sender, Customer receiver, String description, List<Package> packages, List<Shipment> shipments) {
        super();
        if (id != null){
            this.id = id;
        }
        this.sender = sender;
        this.receiver = receiver;
        this.description = description;
        this.packages = packages;
        this.shipments = shipments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    
}
