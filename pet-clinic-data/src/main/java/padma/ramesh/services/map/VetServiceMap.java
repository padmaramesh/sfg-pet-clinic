package padma.ramesh.services.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import padma.ramesh.model.Speciality;
import padma.ramesh.model.Vet;
import padma.ramesh.services.CrudService;
import padma.ramesh.services.SpecialityService;
import padma.ramesh.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Autowired
    private SpecialityService specialityService;

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object != null){
            if(object.getSpecialities().size() >0){
                object.getSpecialities().forEach(speciality -> {
                    if(speciality.getId() == null){
                        Speciality speciality1 = specialityService.save(speciality);
                        speciality.setId(speciality1.getId());
                    }
                });
            }
        }
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }
}
