//package tacos;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import pets.Specie;
//import pets.Pet;
//import pets.Specie.Type;
//import pets.data.IngredientRepository;
//import pets.data.OrderRepository;
//import pets.data.TacoRepository;
//import pets.web.DesignTacoController;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(DesignTacoController.class)
//public class DesignTacoControllerTest {
//
//  @Autowired
//  private MockMvc mockMvc;
//
//  private List<Specie> species;
//
//  private Pet design;
//
//  @MockBean
//  private IngredientRepository ingredientRepository;
//
//  @MockBean
//  private TacoRepository designRepository;
//
//  @MockBean
//  private OrderRepository orderRepository;
//
//  @Before
//  public void setup() {
//    species = Arrays.asList(
//      new Specie("FLTO", "Flour Tortilla", Type.WRAP),
//      new Specie("COTO", "Corn Tortilla", Type.WRAP),
//      new Specie("GRBF", "Ground Beef", Type.PROTEIN),
//      new Specie("CARN", "Carnitas", Type.PROTEIN),
//      new Specie("TMTO", "Diced Tomatoes", Type.VEGGIES),
//      new Specie("LETC", "Lettuce", Type.VEGGIES),
//      new Specie("CHED", "Cheddar", Type.CHEESE),
//      new Specie("JACK", "Monterrey Jack", Type.CHEESE),
//      new Specie("SLSA", "Salsa", Type.SAUCE),
//      new Specie("SRCR", "Sour Cream", Type.SAUCE)
//    );
//
//    when(ingredientRepository.findAll())
//        .thenReturn(species);
//
//    when(ingredientRepository.findById("FLTO")).thenReturn(Optional.of(new Specie("FLTO", "Flour Tortilla", Type.WRAP)));
//    when(ingredientRepository.findById("GRBF")).thenReturn(Optional.of(new Specie("GRBF", "Ground Beef", Type.PROTEIN)));
//    when(ingredientRepository.findById("CHED")).thenReturn(Optional.of(new Specie("CHED", "Cheddar", Type.CHEESE)));
//
//    design = new Pet();
//    design.setName("Test Taco");
//
//    design.setSpecies(Arrays.asList(
//        new Specie("FLTO", "Flour Tortilla", Type.WRAP),
//        new Specie("GRBF", "Ground Beef", Type.PROTEIN),
//        new Specie("CHED", "Cheddar", Type.CHEESE)
//  ));
//
//  }
//
//  @Test
//  public void testShowDesignForm() throws Exception {
//    mockMvc.perform(get("/design"))
//        .andExpect(status().isOk())
//        .andExpect(view().name("design"))
//        .andExpect(model().attribute("wrap", species.subList(0, 2)))
//        .andExpect(model().attribute("protein", species.subList(2, 4)))
//        .andExpect(model().attribute("veggies", species.subList(4, 6)))
//        .andExpect(model().attribute("cheese", species.subList(6, 8)))
//        .andExpect(model().attribute("sauce", species.subList(8, 10)));
//  }
//
//  @Test
//  public void processDesign() throws Exception {
//    when(designRepository.save(design))
//        .thenReturn(design);
//
//    mockMvc.perform(post("/design")
//        .content("name=Test+Taco&ingredients=FLTO,GRBF,CHED")
//        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
//        .andExpect(status().is3xxRedirection())
//        .andExpect(header().stringValues("Location", "/orders/current"));
//  }
//
//}
