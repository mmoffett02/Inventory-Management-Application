# Tech Haven Inventory Management System

## Overview
This project is a customized Spring Framework application with an HTML front-end and a Java backend. It is tailored for a hypothetical customer, Tech Haven, which sells products composed of parts.

## Changes Log

### Part B: README File
- **Prompt**: Create a README file that includes notes describing where in the code to find the changes made for each of parts C to J. Each note should include the prompt, file name, line number, and change.
- **File**: README.md
- **Date**: July 7, 2024
- **Change**: Created the initial README file with placeholders for each part.



### Part C: Customize User Interface
- **Prompt**: Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
- **File**: src/main/resources/templates/mainscreen.html
- **Line Number**: Entire file
- **Change**: Updated the main screen to include the shop name (Tech Haven), product names, and part names.



### Part D: Add an About Page
- **Prompt**: Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
- **File**: src/main/resources/templates/about.html
- **Line Number**: Entire file
- **Change**: Created an "About" page to describe Tech Haven and added a navigation link from the main screen to the "About" page.

- **File**: src/main/resources/templates/mainscreen.html
- **Line Number**: Added within the container div
- **Change**: Added a navigation link to the "About" page.

- **File**: src/main/java/com/example/demo/controllers/MainScreenControllerr.java
- **Line Number**: Added `@GetMapping("/about")` method
- **Change**: Created a method in the controller to handle the "About" page request.



## Part E: Adding Sample Inventory

### Prompt
Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database. Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.

### File: BootStrapData.java
- **File Name:** BootStrapData.java
- **Location:** `src/main/java/com/example/demo/bootstrap/BootStrapData.java`
- **Changes:**
  - Added logic to check if both parts and products are empty.
  - Added sample inventory of five parts and five products.
  - Ensured that duplicates are not added.
  - **Lines Modified:**
    - Check for empty repository: lines 16-19
    - Added sample parts and products: lines 22-61

### Changes in BootStrapData.java
```java
package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

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
        if (partRepository.count() == 0 && productRepository.count() == 0) {
            System.out.println("Adding sample inventory...");

            InhousePart cpu = new InhousePart();
            cpu.setName("CPU");
            cpu.setInv(10);
            cpu.setPrice(299.99);

            InhousePart gpu = new InhousePart();
            gpu.setName("GPU");
            gpu.setInv(5);
            gpu.setPrice(499.99);

            InhousePart ram = new InhousePart();
            ram.setName("RAM");
            ram.setInv(15);
            ram.setPrice(99.99);

            InhousePart motherboard = new InhousePart();
            motherboard.setName("Motherboard");
            motherboard.setInv(7);
            motherboard.setPrice(199.99);

            InhousePart powerSupply = new InhousePart();
            powerSupply.setName("Power Supply");
            powerSupply.setInv(10);
            powerSupply.setPrice(79.99);

            Set<InhousePart> parts = new HashSet<>();
            parts.add(cpu);
            parts.add(gpu);
            parts.add(ram);
            parts.add(motherboard);
            parts.add(powerSupply);

            partRepository.saveAll(parts);

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

            Set<Product> products = new HashSet<>();
            products.add(gamingPC);
            products.add(workstationPC);
            products.add(budgetPC);
            products.add(officePC);
            products.add(developerPC);

            productRepository.saveAll(products);

            System.out.println("Sample inventory added.");
        } else {
            System.out.println("Sample inventory not added. Parts or products already exist.");
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " + productRepository.count());
        productRepository.findAll().forEach(System.out::println);
        System.out.println("Number of Parts: " + partRepository.count());
        partRepository.findAll().forEach(System.out::println);
    }
}
