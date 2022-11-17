package com.potatorestaurant.single.core.modelmapper;

import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.MappingContext;

public class EnumToNameConverter implements ConditionalConverter<Enum<?>, String> {

	@Override
	public String convert(MappingContext<Enum<?>, String> context) {
		return context.getSource() == null ? null : context.getSource().name();
	}

	@Override
	public MatchResult match(Class<?> sourceType, Class<?> destinationType) {
		return MatchResult.FULL;
	}

}
