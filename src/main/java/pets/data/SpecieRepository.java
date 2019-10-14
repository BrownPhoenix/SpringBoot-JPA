package pets.data;

import org.springframework.data.repository.CrudRepository;

import pets.Specie;

public interface SpecieRepository 
         extends CrudRepository<Specie, String> {

}
