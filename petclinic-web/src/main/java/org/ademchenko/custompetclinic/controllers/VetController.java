package org.ademchenko.custompetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    @RequestMapping({"", "/", "/vets/index", "/vets/index.html"})
    private String vetsList(){
        return "vets/index";
    }
}
