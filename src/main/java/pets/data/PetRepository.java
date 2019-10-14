package pets.data;

import org.springframework.data.repository.CrudRepository;

import pets.Pet;

public interface PetRepository 
         extends CrudRepository<Pet, Long> {

}
