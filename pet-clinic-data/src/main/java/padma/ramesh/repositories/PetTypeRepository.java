package padma.ramesh.repositories;

import org.springframework.data.repository.CrudRepository;
import padma.ramesh.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
