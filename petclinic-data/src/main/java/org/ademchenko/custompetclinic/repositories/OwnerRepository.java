package org.ademchenko.custompetclinic.repositories;

import org.ademchenko.custompetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

}
