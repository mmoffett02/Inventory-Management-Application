package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part {
    private String companyName;

    public OutsourcedPart() {
        super();
    }

    public OutsourcedPart(String name, double price, int inv, int maxInv, int minInv, String companyName) {
        super(name, price, inv, maxInv, minInv);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
