package com.codewithadhi.blog.service.mapper;

import com.codewithadhi.blog.domain.UserRtab;
import com.codewithadhi.blog.service.dto.UserRtabDTO;
import org.mapstruct.Mapper;

/**
componentModel = "spring" -> This will create @Component in Impl file
so that we can autowired in the code to import
 */
@Mapper(componentModel = "spring")
public interface UserRtabMapper extends EntityMapper<UserRtabDTO, UserRtab> {
}
