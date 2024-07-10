package com.example.demo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InhousePartTest {

    @Test
    public void testSetPartId() {
        InhousePart ip = new InhousePart();
        ip.setPartId(1);
        assertEquals(1, ip.getPartId());
    }

    @Test
    public void testGetPartId() {
        InhousePart ip = new InhousePart();
        ip.setPartId(2);
        assertEquals(2, ip.getPartId());
    }
}
