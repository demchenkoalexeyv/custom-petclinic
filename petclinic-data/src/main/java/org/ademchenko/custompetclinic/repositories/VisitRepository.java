package org.ademchenko.custompetclinic.repositories;

import org.ademchenko.custompetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
