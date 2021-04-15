package com.example.els.shipmentpackage;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.els.order.Order;

@Entity
@Table(name="packages")
public class Package {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="package_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column
    private Double length;

    @Column
    private Double width;

    @Column
    private Double height;

    @Column
    private Double weight;

    @Column
    private String tag;

    @Column(name = "expiry_date")
    private Date expiryDate;

    public Package() {
        super();
    }

    public Package(Long id, Order order, Double length, Double width, Double height, Double weight, String tag,
            Date expiryDate) {
        super();
        if (id != null){
            this.id = id;
        }
        this.order = order;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.tag = tag;
        this.expiryDate = expiryDate;
    }

    public Package(Order order, Double length, Double width, Double height, Double weight, String tag,
            Date expiryDate) {
        super();
        this.order = order;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.tag = tag;
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }


}
