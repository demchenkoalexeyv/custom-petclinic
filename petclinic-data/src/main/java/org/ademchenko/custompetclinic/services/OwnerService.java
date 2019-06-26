package org.ademchenko.custompetclinic.services;

import org.ademchenko.custompetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
