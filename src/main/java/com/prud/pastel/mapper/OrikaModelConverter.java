package com.prud.pastel.mapper;

import java.util.Map;
import org.springframework.stereotype.Component;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

/**
 * @param <S>
 * 
 */
@Component("orikaConverter")
public class OrikaModelConverter{
	

	private static OrikaModelConverter instance = new OrikaModelConverter();

	public static OrikaModelConverter getInstance() {
		return instance;
	}	
	
	private MapperFacade mapper;
	MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

	public Object map(Object source, Class sourceClass, Class targetClass, Map<String, String> map) {
		ClassMapBuilder<Object, Object> classMapBilder = mapperFactory.classMap(sourceClass,targetClass);
		if(!map.isEmpty()) {
			for(Map.Entry<String,String> s : map.entrySet()) {
				classMapBilder.field(s.getKey(),s.getValue());
			}
		}
		classMapBilder.byDefault().register();
		mapper = mapperFactory.getMapperFacade();
		return mapper.map(source, targetClass);
	}

	
}
