package com.example.demo.repositories;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class InhousePartRepositoryTest {

    @Autowired
    private PartRepository partRepository;

    @Test
    public void testSaveAndFindById() {
        InhousePart ip = new InhousePart();
        ip.setPartId(1);
        ip.setName("Test Part");
        ip.setPrice(100.0);
        ip.setInv(10);
        ip.setMaxInv(20);
        ip.setMinInv(5);
        ip.setMachineId(123);

        partRepository.save(ip);

        Optional<Part> foundPart = partRepository.findById((long) ip.getPartId());
        assertTrue(foundPart.isPresent() && foundPart.get() instanceof InhousePart);
    }
}
