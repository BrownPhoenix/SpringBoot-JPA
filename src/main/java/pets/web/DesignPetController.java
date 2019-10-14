package pets.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pets.Specie;
import pets.Order;
import pets.Pet;
import pets.Specie.Type;
import pets.data.SpecieRepository;
import pets.data.PetRepository;

//tag::injectingDesignRepository[]
//tag::injectingIngredientRepository[]
@Controller
@RequestMapping("/design")
//end::injectingIngredientRepository[]
@SessionAttributes("order")
//tag::injectingIngredientRepository[]
public class DesignPetController {

  private final SpecieRepository specieRepo;

  //end::injectingIngredientRepository[]
  private PetRepository petRepo;

  //end::injectingDesignRepository[]
  /*
  //tag::injectingIngredientRepository[]
  public DesignPetController(IngredientRepository specieRepo) {
    this.specieRepo = specieRepo;
  }
  //end::injectingIngredientRepository[]
   */
  //tag::injectingDesignRepository[]

  @Autowired
  public DesignPetController(
        SpecieRepository specieRepo,
        PetRepository petRepo) {
    this.specieRepo = specieRepo;
    this.petRepo = petRepo;
  }

  @ModelAttribute(name = "order")
  public Order order() {
    return new Order();
  }

  @ModelAttribute(name = "design")
  public Pet design() {
    return new Pet();
  }

  //end::injectingDesignRepository[]

  //tag::injectingIngredientRepository[]

  @GetMapping
  public String showDesignForm(Model model) {
    List<Specie> species = new ArrayList<>();
    specieRepo.findAll().forEach(i -> species.add(i));

    Type[] types = Specie.Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
          filterByType(species, type));
    }

    return "design";
  }
  //end::injectingIngredientRepository[]

//tag::injectingDesignRepository[]
  @PostMapping
  public String processDesign(
      @Valid Pet pet, Errors errors,
      @ModelAttribute Order order) {

    if (errors.hasErrors()) {
      return "design";
    }

    Pet saved = petRepo.save(pet);
    order.addDesign(saved);

    return "redirect:/orders/current";
  }

//end::injectingDesignRepository[]

  private List<Specie> filterByType(
      List<Specie> species, Type type) {
    return species
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
  }

  /*
  //tag::injectingDesignRepository[]
  //tag::injectingIngredientRepository[]

   ...
  //end::injectingIngredientRepository[]
  //end::injectingDesignRepository[]
  */

//tag::injectingDesignRepository[]
//tag::injectingIngredientRepository[]

}
//end::injectingIngredientRepository[]
//end::injectingDesignRepository[]
