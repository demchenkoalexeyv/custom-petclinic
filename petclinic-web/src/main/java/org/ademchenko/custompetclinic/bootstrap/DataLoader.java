package org.ademchenko.custompetclinic.bootstrap;

import org.ademchenko.custompetclinic.services.OwnerService;
import org.ademchenko.custompetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.ademchenko.custompetclinic.model.Owner;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("TestFirst");
        owner1.setLastName("TestLast");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("TestSecond");
        owner2.setLastName("TestSecond");

        System.out.println("ITEMS HAVE BEEN LOADED!");
    }
}
