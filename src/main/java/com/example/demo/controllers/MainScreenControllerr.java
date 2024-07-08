package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenControllerr {
    // private final PartRepository partRepository;
    // private final ProductRepository productRepository;

    private PartService partService;
    private ProductService productService;

    private List<Part> theParts;
    private List<Product> theProducts;

    /* public MainScreenControllerr(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    } */

    @Autowired
    public MainScreenControllerr(PartService partService, ProductService productService) {
        this.partService = partService;
        this.productService = productService;
    }

    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword) {
        // add to the spring model
        List<Part> partList = partService.listAll(partkeyword);
        theModel.addAttribute("parts", partList);
        theModel.addAttribute("partkeyword", partkeyword);

        // theModel.addAttribute("products",productService.findAll());
        List<Product> productList = productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword", productkeyword);

        return "mainscreen";
    }

    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }

    @GetMapping("/buyNow")
    public String buyNow(@RequestParam("productID") Long productID, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(Math.toIntExact(productID));

        if (product != null && product.getInv() > 0) {
            product.setInv(product.getInv() - 1);
            productService.save(product);
            redirectAttributes.addFlashAttribute("message", product.getName() + " purchase successful!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Purchase failed! " + product.getName() + " is out of stock.");
        }

        return "redirect:/mainscreen";
    }
}
