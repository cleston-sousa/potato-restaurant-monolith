package com.potatorestaurant.single.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		IntToEnumConverter intToEnumConverter = new IntToEnumConverter();
		EnumToIntConverter enumToIntConverter = new EnumToIntConverter();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.getConfiguration().getConverters().add(intToEnumConverter);
		modelMapper.getConfiguration().getConverters().add(enumToIntConverter);
		return modelMapper;
	}
}

@SuppressWarnings({ "rawtypes" })
class IntToEnumConverter implements ConditionalConverter<Integer, Enum> {
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