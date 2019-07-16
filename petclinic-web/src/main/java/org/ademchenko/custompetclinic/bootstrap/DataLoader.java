package org.ademchenko.custompetclinic.bootstrap;

import org.ademchenko.custompetclinic.model.*;
import org.ademchenko.custompetclinic.services.OwnerService;
import org.ademchenko.custompetclinic.services.PetTypeService;
import org.ademchenko.custompetclinic.services.SpecialtyService;
import org.ademchenko.custompetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData(){
        Owner owner1 = new Owner();
        owner1.setFirstName("Joe");
        owner1.setLastName("Doe");
        owner1.setAddress("joedoe addr");
        owner1.setCity("City joedoe");
        owner1.setTelephone("111111");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jamie");
        owner2.setLastName("Lan");
        owner2.setAddress("jamielan addr");
        owner2.setCity("City jamielan");
        owner2.setTelephone("222222");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet1First");
        vet1.setLastName("Vet1Last");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2First");
        vet2.setLastName("Vet2Last");

        vetService.save(vet2);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType petTypeDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType petTypeCat = petTypeService.save(cat);

        Pet owner1pet = new Pet();
        owner1pet.setPetType(petTypeDog);
        owner1pet.setOwner(owner1);
        owner1pet.setBirthday(LocalDate.now());
        owner1pet.setName("DogTest");

        owner1.getPets().add(owner1pet);

        Pet owner2pet = new Pet();
        owner2pet.setPetType(petTypeCat);
        owner2pet.setOwner(owner2);
        owner2pet.setBirthday(LocalDate.now());
        owner2pet.setName("CatTest");

        owner2.getPets().add(owner1pet);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentestry = new Speciality();
        dentestry.setDescription("Dentestry");

        Speciality savedRadiology = specialtiesService.save(radiology);
        Speciality savedSurgery = specialtiesService.save(surgery);
        Speciality savedDentestry = specialtiesService.save(dentestry);

        System.out.println("ITEMS HAVE BEEN LOADED!");
    }
}
