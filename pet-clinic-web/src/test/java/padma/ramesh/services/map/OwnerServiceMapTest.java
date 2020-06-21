package padma.ramesh.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import padma.ramesh.model.Owner;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerId = 1L;
    final String lastName = "padma";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        assertEquals(1,ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {
        assertEquals(ownerId,ownerServiceMap.findById(ownerId).getId());
    }

    @Test
    void save() {
        Owner owner = ownerServiceMap.save(Owner.builder().id(2L).lastName("padma").firstName("ramesh").build());
        assertEquals(owner.getFirstName(),"ramesh");
    }

    @Test
    void saveWithNoID() {
        Owner owner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(owner.getId());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertNull(ownerServiceMap.findById(ownerId));
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {

        Owner owner = ownerServiceMap.findByLastName(lastName);
        assertEquals(lastName,owner.getLastName());
    }
}