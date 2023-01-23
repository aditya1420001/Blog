package com.codewithadhi.blog.service.mapper;

import com.codewithadhi.blog.domain.UserRtab;
import com.codewithadhi.blog.service.dto.UserRtabDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-24T01:04:46+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class UserRtabMapperImpl implements UserRtabMapper {

    @Override
    public UserRtabDTO toDto(UserRtab entity) {
        if ( entity == null ) {
            return null;
        }

        UserRtabDTO userRtabDTO = new UserRtabDTO();

        userRtabDTO.setId( entity.getId() );
        userRtabDTO.setName( entity.getName() );
        userRtabDTO.setEmail( entity.getEmail() );
        userRtabDTO.setPassword( entity.getPassword() );
        userRtabDTO.setAbout( entity.getAbout() );

        return userRtabDTO;
    }

    @Override
    public UserRtab toEntity(UserRtabDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserRtab userRtab = new UserRtab();

        userRtab.setId( dto.getId() );
        userRtab.setName( dto.getName() );
        userRtab.setEmail( dto.getEmail() );
        userRtab.setPassword( dto.getPassword() );
        userRtab.setAbout( dto.getAbout() );

        return userRtab;
    }

    @Override
    public void partialUpdate(UserRtab entity, UserRtabDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getPassword() != null ) {
            entity.setPassword( dto.getPassword() );
        }
        if ( dto.getAbout() != null ) {
            entity.setAbout( dto.getAbout() );
        }
    }
}
