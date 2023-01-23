package com.codewithadhi.blog.service.mapper;

import com.codewithadhi.blog.domain.CategoryRtab;
import com.codewithadhi.blog.service.dto.CategoryRtabDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-24T01:04:46+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class CategoryRtabMapperImpl implements CategoryRtabMapper {

    @Override
    public CategoryRtabDTO toDto(CategoryRtab entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryRtabDTO categoryRtabDTO = new CategoryRtabDTO();

        categoryRtabDTO.setId( entity.getId() );
        categoryRtabDTO.setTitle( entity.getTitle() );
        categoryRtabDTO.setDescription( entity.getDescription() );

        return categoryRtabDTO;
    }

    @Override
    public CategoryRtab toEntity(CategoryRtabDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CategoryRtab categoryRtab = new CategoryRtab();

        categoryRtab.setId( dto.getId() );
        categoryRtab.setTitle( dto.getTitle() );
        categoryRtab.setDescription( dto.getDescription() );

        return categoryRtab;
    }

    @Override
    public void partialUpdate(CategoryRtab entity, CategoryRtabDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getTitle() != null ) {
            entity.setTitle( dto.getTitle() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
    }
}
