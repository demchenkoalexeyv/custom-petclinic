package com.ademchenko.custompetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @RequestMapping({"","/", "/index", "/index.html"})
    private String ownersList(){
        return "owners/index";
    }
}
