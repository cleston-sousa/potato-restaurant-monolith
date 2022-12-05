package com.potatorestaurant.single.core.modelmapper;

import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.MappingContext;

import com.potatorestaurant.single.domain.model.AddIngredient;
import com.potatorestaurant.single.domain.model.Ingredient;
import com.potatorestaurant.single.domain.model.IngredientId;

public class LongToAddIngredientConverter implements ConditionalConverter<Long, AddIngredient> {
	@Override
	public AddIngredient convert(MappingContext<Long, AddIngredient> context) {
		if (context.getSource() == null)
			return null;
		AddIngredient result = new AddIngredient();
		result.setIngredientId(new IngredientId());
		result.getIngredientId().setIngredient(new Ingredient());
		result.getIngredientId().getIngredient().setId(context.getSource());
		return result;
	}

	@Override
	public MatchResult match(Class<?> sourceType, Class<?> destinationType) {
		return (destinationType == AddIngredient.class) && (sourceType == Long.class) ? MatchResult.FULL : MatchResult.NONE;
	}
}