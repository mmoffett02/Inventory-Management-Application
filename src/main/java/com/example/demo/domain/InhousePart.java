package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class InhousePart extends Part {
    private int machineId;

    public InhousePart() {
        super();
    }

    public InhousePart(String name, double price, int inv, int maxInv, int minInv, int machineId) {
        super(name, price, inv, maxInv, minInv);
        this.machineId = machineId;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public void setPartId(int partId) {
        super.setId(partId);
    }

    public int getPartId() {
        return (int) super.getId();
    }
}
