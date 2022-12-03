package com.potatorestaurant.single;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.potatorestaurant.single.api.dto.CustomerOrderResponse;
import com.potatorestaurant.single.core.modelmapper.ModelMapperUtils;
import com.potatorestaurant.single.domain.model.CustomerOrder;
import com.potatorestaurant.single.domain.repository.ICustomerOrderRepository;
import com.potatorestaurant.single.domain.service.CustomerOrderService;

@SpringBootApplication
public class PotatoRunApplication implements CommandLineRunner {

	public static void main(String[] args) {

		new SpringApplicationBuilder(PotatoRunApplication.class)
		  .web(WebApplicationType.NONE)
		  .run(args);
	}

	@Autowired
	CustomerOrderService customerOrderService;
	
	@Autowired
	ICustomerOrderRepository customerOrderRepository;

	@Override
	public void run(String... args) throws Exception {
/*
	
		
		CustomerOrderCreateRequest request = new CustomerOrderCreateRequest();
	
		request.setCustomerTableId(1L);
		request.setMenuItemId(5L);
		request.setQuantity(4);
		
		request.getAddIngredient().add(10L);
		request.getRemoveIngredient().add(8L);
		
		
		CustomerOrder order = ModelMapperUtils.map(request, CustomerOrder.class);
		
		
		System.out.println(order);
		/*/
// *
		/*
		CustomerOrder order = new CustomerOrder();
		
		order.setCustomerTable(new CustomerTable());
		order.getCustomerTable().setId(1L);
		
		order.setMenuItem(new MenuItem());
		order.getMenuItem().setId(2L);
		
		order.getAddIngredient().add(new AddIngredient());
		order.getAddIngredient().get(0).setIngredientId(new IngredientId());
		order.getAddIngredient().get(0).getIngredientId().setIngredient(new Ingredient());
		order.getAddIngredient().get(0).getIngredientId().getIngredient().setId(2L);

		
		
		
		order.getRemoveIngredient().add(new RemoveIngredient());
		order.getRemoveIngredient().get(0).setIngredientId(new IngredientId());
		order.getRemoveIngredient().get(0).getIngredientId().setIngredient(new Ingredient());
		order.getRemoveIngredient().get(0).getIngredientId().getIngredient().setId(1L);

		
		
		order.setQuantity(1);

		
		
		
		/*


		CustomerOrder order = new CustomerOrder();
		
		order.setCustomerTable(new CustomerTable());
		order.getCustomerTable().setId(1L);
		
		order.setMenuItem(new MenuItem());
		order.getMenuItem().setId(1L);

		order.setQuantity(2);
		 
		 * */
		/*
		customerOrderService.create(order);
		
/*
		order = new CustomerOrder();
		order.setStatus(CustomerOrderStatusEnum.DELIVERED);

//		customerOrderService.edit(5L, order);
		
		
//		customerOrderService.delete(2L);
 
 */
		
		
		Optional<CustomerOrder> order = customerOrderRepository.findById(6L);
		
		
		
		CustomerOrderResponse response = ModelMapperUtils.map(order, CustomerOrderResponse.class);
		
		System.out.println(response);
	}
	
	
	
	
}
