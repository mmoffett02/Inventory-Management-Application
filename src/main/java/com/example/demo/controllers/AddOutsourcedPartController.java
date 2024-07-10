package com.example.demo.controllers;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddOutsourcedPartController {
    @Autowired
    private PartService partService;

    @GetMapping("/showFormAddOutPart")
    public String showFormForAdd(Model theModel) {
        OutsourcedPart outsourcedPart = new OutsourcedPart();
        theModel.addAttribute("outsourcedpart", outsourcedPart);
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String saveOutsourcedPart(@ModelAttribute("outsourcedpart") OutsourcedPart thePart, BindingResult result, Model model) {
        if (!thePart.isInvValid()) {
            result.rejectValue("inv", "error.part", "Inventory must be between Min and Max values.");
            return "OutsourcedPartForm";
        }
        partService.save(thePart);
        return "redirect:/";
    }

    @GetMapping("/updateOutsourcedPart/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        OutsourcedPart part = (OutsourcedPart) partService.findById(id);
        model.addAttribute("outsourcedpart", part);
        return "OutsourcedPartForm";
    }
}
