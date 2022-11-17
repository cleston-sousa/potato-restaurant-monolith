package com.potatorestaurant.single.core.modelmapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtils {

	private static ModelMapper modelMapper;

	@Autowired
	public ModelMapperUtils(ModelMapper modelMapper) {
		ModelMapperUtils.modelMapper = modelMapper;
	}

	public static <E> E map(Object source, Class<E> destinationType) {
		return modelMapper.map(source, destinationType);
	}

	public static void map(Object source, Object destination) {
		modelMapper.map(source, destination);
	}

	public static <E, L> List<E> mapList(Collection<L> source, Class<E> destinationType) {
		return source.stream().map(sourceItem -> map(sourceItem, destinationType)).collect(Collectors.toList());
	}

}
