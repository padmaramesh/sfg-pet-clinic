package padma.ramesh.repositories;

import org.springframework.data.repository.CrudRepository;
import padma.ramesh.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String name);
}
