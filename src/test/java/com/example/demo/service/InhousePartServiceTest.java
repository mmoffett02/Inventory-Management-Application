package com.example.demo.service;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.repositories.PartRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class InhousePartServiceTest {

    @Mock
    private PartRepository partRepository;

    @InjectMocks
    private PartServiceImpl partService;

    @Test
    public void testFindById() {
        InhousePart ip = new InhousePart();
        ip.setPartId(1);
        ip.setName("Test Part");

        when(partRepository.findById(1L)).thenReturn(Optional.of(ip));

        InhousePart foundPart = (InhousePart) partService.findById(1L);
        assertEquals("Test Part", foundPart.getName());
    }
}
