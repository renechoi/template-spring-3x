package kr.rene.template.sampledomain1.common.mapper.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
public class ModelMapperBasedVoMapper {

	private static final ModelMapper modelMapper = new ModelMapper();

	static {
		modelMapper.addConverter(ModelMapperBasedVoMapper::convertLocalDateTime);

		modelMapper.getConfiguration();
		// .setMatchingStrategy(MatchingStrategies.STRICT)
		// .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR)
		// .setDestinationNamingConvention(NamingConventions.JAVABEANS_ACCESSOR);

	}

	// Java 8 LocalDateTime 컨버터 구현
	private static LocalDateTime convertLocalDateTime(MappingContext<Object, Object> context) {
		return context.getSource() == null ? null : (LocalDateTime)context.getSource();
	}

	public static ModelMapper getModelMapper() {
		return modelMapper;
	}

	public static <T, U> U convert(T from, Class<U> toClass) {
		return modelMapper.map(from, toClass);
	}

	public static <T, U> List<U> convert(List<T> fromList, Class<U> toClass) {
		return fromList.stream()
			.map(item -> convert(item, toClass))
			.collect(Collectors.toList());
	}

	public static <T, U> U updateWithNonNullValues(T source, U destination) {
		modelMapper.map(source, destination);
		return destination;
	}
}
