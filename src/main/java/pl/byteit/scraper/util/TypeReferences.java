package pl.byteit.scraper.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.util.List;

public class TypeReferences {

	private static final ObjectMapper OBJECT_MAPPER = ObjectMapperFactory.objectMapper();

	public static <T> TypeReference<List<T>> listTypeOf(Class<T> aClass) {
		return new TypeReference<List<T>>() {
			@Override
			public Type getType() {
				return OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, aClass);
			}
		};
	}

	public static <T> TypeReference<T> typeOf(Class<T> aClass) {
		return new TypeReference<T>() {
			@Override
			public Type getType() {
				return aClass;
			}
		};
	}

}
