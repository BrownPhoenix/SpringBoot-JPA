package pets.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pets.Specie;
import pets.data.SpecieRepository;

@Component
public class SpecieByIdConverter implements Converter<String, Specie> {

  private SpecieRepository specieRepo;

  @Autowired
  public SpecieByIdConverter(SpecieRepository specieRepo) {
    this.specieRepo = specieRepo;
  }
  
  @Override
  public Specie convert(String id) {
    Optional<Specie> optionalSpecie = specieRepo.findById(id);
	return optionalSpecie.isPresent() ?
		   optionalSpecie.get() : null;
  }

}
