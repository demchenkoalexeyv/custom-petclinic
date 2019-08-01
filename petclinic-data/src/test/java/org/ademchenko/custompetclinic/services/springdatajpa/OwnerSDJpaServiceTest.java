package org.ademchenko.custompetclinic.services.springdatajpa;

import org.ademchenko.custompetclinic.model.Owner;
import org.ademchenko.custompetclinic.repositories.OwnerRepository;
import org.ademchenko.custompetclinic.repositories.PetRepository;
import org.ademchenko.custompetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;

    private Owner owner;

    private final String OWNER_LAST_NAME = "lastName";

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(OWNER_LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any()))
                .thenReturn(Owner.builder()
                        .id(1L)
                        .lastName(OWNER_LAST_NAME)
                        .build());

        Owner owner = service.findByLastName(OWNER_LAST_NAME);

        assertEquals(OWNER_LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);
        assertNotNull(service.findAll());
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        assertNotNull(service.findById(1L));
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        assertNotNull(service.save(Owner.builder().id(1L).build()));
    }

    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}