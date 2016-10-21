package no.insurance.domain;

import no.insurance.helper.Insurance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by p on 21/10/2016.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Insurance type;
    String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Insurance getType() {
        return type;
    }

    public void setType(Insurance type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
