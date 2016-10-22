package no.insurance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 * Created by p on 22/10/2016.
 */
@Entity
public class Service {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    @NotNull
    Long userId;
    @NotNull
    Integer type;
    @NotNull
    String product;
    @NotNull
    Integer state;
    @NotNull
    Double price;

    public Service() {

    }

    public Service(Long id, Long userId, Integer type, String product, Integer state, Double price) {
        Id = id;
        this.userId = userId;
        this.type = type;
        this.product = product;
        this.state = state;
        this.price = price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
