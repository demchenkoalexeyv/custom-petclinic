package org.ademchenko.custompetclinic.repositories;

import org.ademchenko.custompetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
