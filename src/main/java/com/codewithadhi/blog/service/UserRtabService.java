package com.codewithadhi.blog.service;

import com.codewithadhi.blog.service.dto.UserRtabDTO;

import java.util.List;


public interface UserRtabService {

    UserRtabDTO getUserById(Long userId);

    UserRtabDTO createUser(UserRtabDTO userRtabDTO);

    List<UserRtabDTO> getAllUsers();

    void deleteUserById(Long id);

    UserRtabDTO partialUpdate(UserRtabDTO userRtabDTO);

    UserRtabDTO save(UserRtabDTO userRtabDTO);

}
