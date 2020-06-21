package padma.ramesh.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import padma.ramesh.model.*;
import padma.ramesh.services.OwnerService;
import padma.ramesh.services.PetTypeService;
import padma.ramesh.services.SpecialityService;
import padma.ramesh.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    OwnerService ownerService;
    VetService vetService;
    PetTypeService petTypeService;
    SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... strings) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality dentist = new Speciality();
        dentist.setDescription("Dentist");
        Speciality savedDentist = specialityService.save(dentist);

        Speciality surgoen = new Speciality();
        surgoen.setDescription("Surgoen");
        Speciality savedSergoen = specialityService.save(surgoen);


        System.out.println("PetTypes loaded......");


        Owner owner = new Owner();
        owner.setFirstName("ramesh");
        owner.setLastName("padma");
        owner.setAddress("Chilkanagar");
        owner.setCity("Hyderabad");
        owner.setTelephone("78978787878 ");

        Pet rameshPet = new Pet();
        rameshPet.setPetType(savedDogPetType);
        rameshPet.setOwner(owner);
        rameshPet.setBirthDate(LocalDate.now());
        rameshPet.setName("Rani");
        owner.getPets().add(rameshPet);

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("padma");
        owner1.setLastName("rishith");
        owner.setAddress("Chilkanagar");
        owner.setCity("Hyderabad");
        owner.setTelephone("78978787878 ");


        Pet padmaCat = new Pet();
        padmaCat.setName("Cat");
        padmaCat.setBirthDate(LocalDate.now());
        padmaCat.setPetType(savedCatPetType);
        padmaCat.setOwner(owner1);
        owner1.getPets().add(padmaCat);

        ownerService.save(owner1);

        System.out.println("Owners loaded......");

        Vet vet = new Vet();
        vet.setLastName("padma");
        vet.setFirstName("vedhashree");
        vet.getSpecialities().add(savedDentist);

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setLastName("padma");
        vet1.setFirstName("sharanmai");

        vet1.getSpecialities().add(savedSergoen);
        vetService.save(vet1);

        System.out.println("Vets loaded.....");
    }
}
