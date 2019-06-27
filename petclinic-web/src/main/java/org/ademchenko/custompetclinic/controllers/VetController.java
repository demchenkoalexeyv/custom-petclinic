package org.ademchenko.custompetclinic.controllers;

import org.ademchenko.custompetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/vets/index", "/vets/index.html"})
    private String vetsList(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
