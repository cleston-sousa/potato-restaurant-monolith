package com.potatorestaurant.single.core.modelmapper;

import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.MappingContext;

@SuppressWarnings({ "rawtypes" })
class EnumToIntConverter implements ConditionalConverter<Enum, Integer> {
	public Integer convert(MappingContext<Enum, Integer> context) {
		Enum source = context.getSource();
		try {
			if (source != null)
				return source.ordinal();
		} catch (IllegalArgumentException ignore) {
		}
		return null;
	}

	public MatchResult match(Class<?> sourceType, Class<?> destinationType) {
		return isEnum(sourceType) && (destinationType == Integer.class) ? MatchResult.FULL : MatchResult.NONE;
	}

	private boolean isEnum(Class<?> type) {
		return type.isAnonymousClass() ? isEnum(type.getSuperclass()) : type.isEnum();
	}
}