package com.potatorestaurant.single.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		
		modelMapper.getConfiguration().getConverters().add(new IntToEnumConverter());
		modelMapper.getConfiguration().getConverters().add(new EnumToIntConverter());
		modelMapper.getConfiguration().getConverters().add(new LongToAddIngredientConverter());
		modelMapper.getConfiguration().getConverters().add(new LongToRemoveIngredientConverter());
		
		return modelMapper;
	}
}


