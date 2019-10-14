package pets;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pets.Specie.Type;
import pets.data.SpecieRepository;

@SpringBootApplication
public class PetCloudApplication {

  public static void main(String[] args) {
    SpringApplication.run(PetCloudApplication.class, args);
  }

  @Bean
  public CommandLineRunner dataLoader(SpecieRepository repo) {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        repo.save(new Specie("CAT", "Cat", Type.ANIMAL));
        repo.save(new Specie("DOG", "Dog", Type.ANIMAL));
        repo.save(new Specie("LIZ", "Lizard", Type.ANIMAL));
        repo.save(new Specie("SNK", "Snake", Type.ANIMAL));
        repo.save(new Specie("SPR", "Spider", Type.ANIMAL));
        repo.save(new Specie("FISH","Fish", Type.ANIMAL));
        
        repo.save(new Specie("MALE", "Male", Type.GENDER));
        repo.save(new Specie("FEM", "Female", Type.GENDER));
        
        repo.save(new Specie("LB", "Light Brown", Type.COLOUR));
        repo.save(new Specie("DB", "Dark Brown", Type.COLOUR));
        repo.save(new Specie("BLCK", "Black", Type.COLOUR));
        repo.save(new Specie("WHTE", "White", Type.COLOUR));
        repo.save(new Specie("RED", "Red/Ginger/Orange", Type.COLOUR));
        repo.save(new Specie("YELO", "Yellow", Type.COLOUR));
        repo.save(new Specie("GREY", "Grey", Type.COLOUR));
        
        repo.save(new Specie("SPOT", "Spotted pattern", Type.UNIQUE_DETAIL));
        repo.save(new Specie("STRI", "Striped pattern", Type.UNIQUE_DETAIL));
        repo.save(new Specie("ST", "Short tail", Type.UNIQUE_DETAIL));
        repo.save(new Specie("LT", "Long Tail", Type.UNIQUE_DETAIL));
        
        repo.save(new Specie("FRI", "Friendly", Type.PERSONALITY));
        repo.save(new Specie("ARGE", "Agressive", Type.PERSONALITY));
        repo.save(new Specie("ADV", "Adventurous", Type.PERSONALITY));
        repo.save(new Specie("SHY", "Skittish/Shy", Type.PERSONALITY));
        repo.save(new Specie("LOUD", "Loud", Type.PERSONALITY));
        repo.save(new Specie("QIET", "Quiet", Type.PERSONALITY));
      }
    };
  }
  
}
