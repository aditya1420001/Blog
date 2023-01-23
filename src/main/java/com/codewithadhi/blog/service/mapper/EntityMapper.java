package com.codewithadhi.blog.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 componentModel = "spring" -> This will create @Component in Impl file
 so that we can autowired in the code to import
 */
public interface EntityMapper<D, E> {
    D toDto(E entity);

    E toEntity(D dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget E entity, D dto);
}
