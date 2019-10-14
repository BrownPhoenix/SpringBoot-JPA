package pets.data;

import org.springframework.data.repository.CrudRepository;

import pets.Order;

public interface OrderRepository 
         extends CrudRepository<Order, Long> {

}
