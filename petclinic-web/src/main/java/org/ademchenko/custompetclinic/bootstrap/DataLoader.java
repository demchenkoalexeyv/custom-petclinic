package org.ademchenko.custompetclinic.bootstrap;

import org.ademchenko.custompetclinic.model.*;
import org.ademchenko.custompetclinic.services.*;
import org.ademchenko.custompetclinic.services.map.VisitMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtiesService;
    private final VisitService visitService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtiesService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData(){
        Owner joe = new Owner();
        joe.setFirstName("Joe");
        joe.setLastName("Doe");
        joe.setAddress("joedoe addr");
        joe.setCity("City joedoe");
        joe.setTelephone("111111");

        ownerService.save(joe);

        Owner jamie = new Owner();
        jamie.setFirstName("Jamie");
        jamie.setLastName("Lan");
        jamie.setAddress("jamielan addr");
        jamie.setCity("City jamielan");
        jamie.setTelephone("222222");

        ownerService.save(jamie);

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

        Pet joeDog = new Pet();
        joeDog.setPetType(petTypeDog);
        joeDog.setOwner(joe);
        joeDog.setBirthday(LocalDate.now());
        joeDog.setName("DogTest");
        petService.save(joeDog);
        joe.getPets().add(joeDog);

        Pet jamieCat = new Pet();
        jamieCat.setPetType(petTypeCat);
        jamieCat.setOwner(jamie);
        jamieCat.setBirthday(LocalDate.now());
        jamieCat.setName("CatTest");
        petService.save(jamieCat);

        jamie.getPets().add(jamieCat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentestry = new Speciality();
        dentestry.setDescription("Dentestry");

        Speciality savedRadiology = specialtiesService.save(radiology);
        Speciality savedSurgery = specialtiesService.save(surgery);
        Speciality savedDentestry = specialtiesService.save(dentestry);

        Visit catVisit = new Visit();
        catVisit.setPet(jamieCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Cat is felling bad");

        visitService.save(catVisit);

        Visit dogVisit = new Visit();
        dogVisit.setPet(joeDog);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Dog is felling bad");

        visitService.save(dogVisit);

        System.out.println("ITEMS HAVE BEEN LOADED!");
    }
}
