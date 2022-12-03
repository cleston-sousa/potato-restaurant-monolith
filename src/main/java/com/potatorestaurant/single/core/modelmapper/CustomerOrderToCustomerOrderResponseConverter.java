package com.potatorestaurant.single.core.modelmapper;

import java.util.Objects;

import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.MappingContext;
import org.modelmapper.spi.ConditionalConverter.MatchResult;

import com.potatorestaurant.single.api.dto.CustomerOrderIngredientResponse;
import com.potatorestaurant.single.api.dto.CustomerOrderResponse;
import com.potatorestaurant.single.domain.model.CustomerOrder;
import com.potatorestaurant.single.domain.model.RemoveIngredient;

public class CustomerOrderToCustomerOrderResponseConverter implements ConditionalConverter<CustomerOrder, CustomerOrderResponse> {

	@Override
	public CustomerOrderResponse convert(MappingContext<CustomerOrder, CustomerOrderResponse> context) {
		
		
		CustomerOrder source = context.getSource();
		
		if(source!=null) {
			
			CustomerOrderResponse result = new CustomerOrderResponse();	
			
			
			result.setId(source.getId());
			result.setCustomerTableId(source.getCustomerTable().getId());
			result.setCustomerTableName(source.getCustomerTable().getName());
			result.setMenuItemId(source.getMenuItem().getId());
			result.setMenuItemName(source.getMenuItem().getName());
			result.setQuantity(source.getQuantity());
			result.setStatus(source.getStatus().ordinal());
			result.setStatusDescription(source.getStatus().name());
			result.setCreatedAt(source.getCreatedAt());
			result.setUpdatedAt(source.getUpdatedAt());
			
			if(Objects.nonNull(source.getAddIngredient())) {
				source.getAddIngredient().stream().forEach(item -> {
					CustomerOrderIngredientResponse ingredientResponse = new CustomerOrderIngredientResponse();
					ingredientResponse.setId(item.getIngredientId().getIngredient().getId());
					ingredientResponse.setName(item.getIngredientId().getIngredient().getName());
					ingredientResponse.setPrice(item.getIngredientId().getIngredient().getPrice());
					result.getAddIngredient().add(ingredientResponse);
				});
			}
			
			if(Objects.nonNull(source.getRemoveIngredient())) {
				source.getRemoveIngredient().stream().forEach(item -> {
					CustomerOrderIngredientResponse ingredientResponse = new CustomerOrderIngredientResponse();
					ingredientResponse.setId(item.getIngredientId().getIngredient().getId());
					ingredientResponse.setName(item.getIngredientId().getIngredient().getName());
					result.getRemoveIngredient().add(ingredientResponse);
				});
			}
			
			return result; 
			
		}
		
		return null;
	}

	@Override
	public MatchResult match(Class<?> sourceType, Class<?> destinationType) {
		return (destinationType == CustomerOrderResponse.class) && (sourceType == CustomerOrder.class) ? MatchResult.FULL : MatchResult.NONE;
	}

}
