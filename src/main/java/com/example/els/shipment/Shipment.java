package com.example.els.shipment;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.els.order.Order;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="shipment_id")
    private Long id;

    @ManyToMany
    @JoinTable(name = "shipment_order", joinColumns = @JoinColumn(name="shipment_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;

    @Column(name="vehicle_id")
    private Long vehicleId;


    public Shipment() {
        super();
    }

    public Shipment(List<Order> orders, Long vehicleId) {
        super();
        this.orders = orders;
        this.vehicleId = vehicleId;
    }

    public Shipment(Long id, List<Order> orders, Long vehicleId) {
        super();
        if (id != null){
            this.id = id;
        }
        this.orders = orders;
        this.vehicleId = vehicleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }


}
