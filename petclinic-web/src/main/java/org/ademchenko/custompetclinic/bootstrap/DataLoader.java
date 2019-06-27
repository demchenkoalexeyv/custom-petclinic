package org.ademchenko.custompetclinic.bootstrap;

import org.ademchenko.custompetclinic.model.Owner;
import org.ademchenko.custompetclinic.model.Vet;
import org.ademchenko.custompetclinic.services.OwnerService;
import org.ademchenko.custompetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Owner1First");
        owner1.setLastName("Owner1Last");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Owner2First");
        owner2.setLastName("Owner2Last");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet1First");
        vet1.setLastName("Vet1Last");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2First");
        vet2.setLastName("Vet2Last");

        vetService.save(vet2);

        System.out.println("ITEMS HAVE BEEN LOADED!");
    }
}
