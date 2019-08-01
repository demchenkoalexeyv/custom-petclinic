package org.ademchenko.custompetclinic.services.map;

import org.ademchenko.custompetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    private final Long OWNER_ID = 1L;
    private final String OWNER_LAST_NAME = "LastName";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(OWNER_ID).lastName(OWNER_LAST_NAME).build());
    }

    @Test
    void findAll() {
        assertEquals(1, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(OWNER_ID);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(OWNER_ID));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
        Long id = 2L;
        Owner savedOwner = ownerServiceMap.save(Owner.builder().id(id).build());
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveWithoutId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(OWNER_ID);

        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner ownerWithLastName = ownerServiceMap.findByLastName(OWNER_LAST_NAME);

        assertNotNull(ownerWithLastName);
    }
}