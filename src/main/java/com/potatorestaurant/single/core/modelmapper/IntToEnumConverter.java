package com.potatorestaurant.single.core.modelmapper;

import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.MappingContext;

@SuppressWarnings({ "rawtypes" })
public class IntToEnumConverter implements ConditionalConverter<Integer, Enum> {
	public Enum convert(MappingContext<Integer, Enum> context) {
		Integer source = context.getSource();
		if (source == null)
			return null;
		try {
			return (Enum) ((Class) context.getDestinationType()).getEnumConstants()[source.intValue()];
		} catch (IllegalArgumentException ignore) {
		}
		return null;
	}

	public MatchResult match(Class<?> sourceType, Class<?> destinationType) {
		return isEnum(destinationType) && (sourceType == Integer.class) ? MatchResult.FULL : MatchResult.NONE;
	}

	private boolean isEnum(Class<?> type) {
		return type.isAnonymousClass() ? isEnum(type.getSuperclass()) : type.isEnum();
	}
}