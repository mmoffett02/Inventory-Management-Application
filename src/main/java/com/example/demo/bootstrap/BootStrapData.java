package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        // Check if both part and product lists are empty
        if (partRepository.count() == 0 && productRepository.count() == 0) {
            System.out.println("Adding sample inventory...");

            // Create and add sample Inhouse parts
            InhousePart cpu = new InhousePart("CPU", 299.99, 10, 50, 1, 123);
            InhousePart gpu = new InhousePart("GPU", 499.99, 5, 30, 1, 456);
            InhousePart ram = new InhousePart("RAM", 99.99, 15, 100, 1, 789);
            InhousePart motherboard = new InhousePart("Motherboard", 199.99, 7, 20, 1, 101);
            InhousePart powerSupply = new InhousePart("Power Supply", 79.99, 10, 40, 1, 102);

            partRepository.save(cpu);
            partRepository.save(gpu);
            partRepository.save(ram);
            partRepository.save(motherboard);
            partRepository.save(powerSupply);

            // Verify parts saved
            partRepository.findAll().forEach(part -> System.out.println("Saved Part: " + part.getName()));

            // Create and add sample products
            Product gamingPC = new Product();
            gamingPC.setName("Gaming PC");
            gamingPC.setInv(5);
            gamingPC.setPrice(1499.99);

            Product workstationPC = new Product();
            workstationPC.setName("Workstation PC");
            workstationPC.setInv(3);
            workstationPC.setPrice(1999.99);

            Product budgetPC = new Product();
            budgetPC.setName("Budget PC");
            budgetPC.setInv(8);
            budgetPC.setPrice(499.99);

            Product officePC = new Product();
            officePC.setName("Office PC");
            officePC.setInv(7);
            officePC.setPrice(699.99);

            Product developerPC = new Product();
            developerPC.setName("Developer PC");
            developerPC.setInv(4);
            developerPC.setPrice(999.99);

            productRepository.save(gamingPC);
            productRepository.save(workstationPC);
            productRepository.save(budgetPC);
            productRepository.save(officePC);
            productRepository.save(developerPC);

            // Verify products saved
            productRepository.findAll().forEach(product -> System.out.println("Saved Product: " + product.getName()));

            System.out.println("Sample inventory added.");
        } else {
            System.out.println("Sample inventory not added. Parts or products already exist.");
        }

        // Print parts and products for verification
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " + productRepository.count());
        productRepository.findAll().forEach(System.out::println);
        System.out.println("Number of Parts: " + partRepository.count());
        partRepository.findAll().forEach(System.out::println);
    }
}
