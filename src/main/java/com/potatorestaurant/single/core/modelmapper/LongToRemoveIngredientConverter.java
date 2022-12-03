package com.potatorestaurant.single.core.modelmapper;

import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.MappingContext;

import com.potatorestaurant.single.domain.model.Ingredient;
import com.potatorestaurant.single.domain.model.IngredientId;
import com.potatorestaurant.single.domain.model.RemoveIngredient;

public class LongToRemoveIngredientConverter implements ConditionalConverter<Long, RemoveIngredient> {
	@Override
	public RemoveIngredient convert(MappingContext<Long, RemoveIngredient> context) {
		if (context.getSource() == null)
			return null;
		RemoveIngredient result = new RemoveIngredient();
		result.setIngredientId(new IngredientId());
		result.getIngredientId().setIngredient(new Ingredient());
		result.getIngredientId().getIngredient().setId(context.getSource());
		return result;
	}

	@Override
	public MatchResult match(Class<?> sourceType, Class<?> destinationType) {
		return (destinationType == RemoveIngredient.class) && (sourceType == Long.class) ? MatchResult.FULL : MatchResult.NONE;
	}
}