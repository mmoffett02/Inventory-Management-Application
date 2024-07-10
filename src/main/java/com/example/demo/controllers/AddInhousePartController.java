package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddInhousePartController {
    @Autowired
    private PartService partService;

    @GetMapping("/showFormAddInPart")
    public String showFormForAdd(Model theModel) {
        InhousePart inhousePart = new InhousePart();
        theModel.addAttribute("inhousepart", inhousePart);
        return "InhousePartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String saveInhousePart(@ModelAttribute("inhousepart") InhousePart thePart, BindingResult result, Model model) {
        if (thePart.getInv() < thePart.getMinInv()) {
            result.rejectValue("inv", "error.inhousepart", "Inventory cannot be less than the minimum inventory.");
        }
        if (thePart.getInv() > thePart.getMaxInv()) {
            result.rejectValue("inv", "error.inhousepart", "Inventory cannot be greater than the maximum inventory.");
        }
        if (result.hasErrors()) {
            return "InhousePartForm";
        }
        partService.save(thePart);
        return "redirect:/";
    }

    @GetMapping("/updateInhousePart/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        InhousePart part = (InhousePart) partService.findById(id);
        model.addAttribute("inhousepart", part);
        return "InhousePartForm";
    }
}
