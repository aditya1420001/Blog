package com.codewithadhi.blog.service.impl;

import com.codewithadhi.blog.domain.UserRtab;
import com.codewithadhi.blog.execptions.BlogAppServiceException;
import com.codewithadhi.blog.repositories.UserRtabRepository;
import com.codewithadhi.blog.service.UserRtabService;
import com.codewithadhi.blog.service.dto.UserRtabDTO;
import com.codewithadhi.blog.service.mapper.UserRtabMapperImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class UserRtabServiceImpl implements UserRtabService {
    private final UserRtabRepository userRtabRepository;
    private final UserRtabMapperImpl userRtabMapper;

    @Override
    public UserRtabDTO getUserById(Long userId) {
        log.info("REST request to find User by id {}", userId);
        if (Objects.isNull(userId)) {
            log.error("Fetching user failed, user id:'{}' cannot be null", userId);
            throw new BlogAppServiceException("Exception occurred while fetching user", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        UserRtab userRtab = this.userRtabRepository.findById(userId).
                orElseThrow(() -> new BlogAppServiceException("User not found for id : ".concat(String.valueOf(userId))));

        return this.userRtabMapper.toDto(userRtab);
    }

    @Override
    public UserRtabDTO createUser(UserRtabDTO userRtabDTO) {
        log.info("REST request to create user for :{}", userRtabDTO);
        if (Objects.isNull(userRtabDTO)) {
            log.error("User creation failed, user id:'{}' cannot be null", userRtabDTO);
            throw new BlogAppServiceException("Exception occurred while creating user", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        UserRtab savedUserRtab = this.userRtabRepository.save(userRtabMapper.toEntity(userRtabDTO));
        return userRtabMapper.toDto(savedUserRtab);
    }

    @Override
    public List<UserRtabDTO> getAllUsers() {
        log.info("REST request to find all users");

        return userRtabRepository.findAll()
                .stream()
                .map(userRtabMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(Long userId) {
        log.info("REST request to delete for user id :{}", userId);
        if (Objects.isNull(userId)) {
            log.error("User deletion failed, User ID cannot be null");
            throw new BlogAppServiceException("Exception occurred while deleting user", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        UserRtab userRtab = userRtabRepository.findById(userId)
                .orElseThrow(() -> new BlogAppServiceException("Exception occurred, no user found with id :".concat(String.valueOf(userId))));
        userRtabRepository.delete(userRtab);
    }

    @Override
    public UserRtabDTO partialUpdate(UserRtabDTO userRtabDTO) {
        if (Objects.isNull(userRtabDTO.getId())){
            throw new BlogAppServiceException("user id cannot be null", HttpStatus.NOT_FOUND);
        }
        return userRtabRepository
                .findById(userRtabDTO.getId())
                .map(existingEntity -> {
                     userRtabMapper.partialUpdate(existingEntity, userRtabDTO);

                     return existingEntity;
                })
                .map(userRtabMapper::toDto)
                .orElseThrow(() -> new BlogAppServiceException("No user found with Id :"+userRtabDTO.getId(), HttpStatus.NOT_FOUND));
    }

    @Override
    public UserRtabDTO save(UserRtabDTO userRtabDTO) {
        UserRtab userRtab = userRtabRepository.save(userRtabMapper.toEntity(userRtabDTO));
        return userRtabMapper.toDto(userRtab);
    }
}
