package no.insurance.domain;

import no.insurance.helper.Insurance;
import no.insurance.helper.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by p on 22/10/2016.
 */
@Entity
public class Service {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    Insurance type;
    String product;
    Status deal;
    Double price;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Insurance getType() {
        return type;
    }

    public void setType(Insurance type) {
        this.type = type;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Status getDeal() {
        return deal;
    }

    public void setDeal(Status deal) {
        this.deal = deal;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
