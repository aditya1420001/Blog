package com.codewithadhi.blog.service.impl;

import com.codewithadhi.blog.domain.CategoryRtab;
import com.codewithadhi.blog.execptions.BlogAppServiceException;
import com.codewithadhi.blog.repositories.CategoryRtabRepository;
import com.codewithadhi.blog.service.CategoryRtabService;
import com.codewithadhi.blog.service.dto.CategoryRtabDTO;
import com.codewithadhi.blog.service.mapper.CategoryRtabMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryRtabServiceImpl implements CategoryRtabService {
    private final CategoryRtabRepository categoryRtabRepository;
    private final CategoryRtabMapper categoryRtabMapper;

    @Override
    public CategoryRtabDTO createCategory(CategoryRtabDTO categoryRtabDTO) {
        CategoryRtab newCategoryRtab = categoryRtabRepository.save(categoryRtabMapper.toEntity(categoryRtabDTO));
        return categoryRtabMapper.toDto(newCategoryRtab);
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRtabRepository.deleteById(categoryId);
    }

    @Override
    public void deleteCategory(CategoryRtabDTO categoryRtabDTO) {
        CategoryRtab categoryRtab = categoryRtabRepository.findById(categoryRtabDTO.getId())
                .orElseThrow(() -> new BlogAppServiceException("No category found with id:{}" + categoryRtabDTO.getId(), HttpStatus.NOT_FOUND));
        categoryRtabRepository.delete(categoryRtab);
    }

    @Override
    public CategoryRtabDTO getCategoryById(Long categoryId) {
        return categoryRtabRepository.findById(categoryId)
                .map(categoryRtabMapper::toDto)
                .orElseThrow(() -> new BlogAppServiceException("No category found for id :{}" + categoryId, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<CategoryRtabDTO> getAllCategories() {
        return categoryRtabRepository.findAll().stream()
                .map(categoryRtabMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryRtab save(CategoryRtab categoryRtab) {
        CategoryRtab savedCategoryRtab = categoryRtabRepository.save(categoryRtab);
        return savedCategoryRtab;
    }

//    @Override
//    public CategoryRtabDTO partialUpdate(CategoryRtabDTO categoryRtabDTO) {
//        CategoryRtab categoryRtab = categoryRtabRepository
//                .findById(categoryRtabDTO.getId())
//                .map(existingEntity -> {
//                    categoryRtabMapper.partialUpdate(existingEntity, categoryRtabDTO);
//
//                    return existingEntity;
//                })
//                .orElseThrow(() -> new BlogAppServiceException("No Category entry found for id:" + categoryRtabDTO.getId(), HttpStatus.NOT_FOUND));
//        CategoryRtab savedCategoryRtab = this.save(categoryRtab);
//        return categoryRtabMapper.toDto(savedCategoryRtab);
//    }

    @Override
    public CategoryRtabDTO partialUpdate(CategoryRtabDTO categoryRtabDTO) {
        return categoryRtabRepository
                .findById(categoryRtabDTO.getId())
                .map(existingEntity -> {
                    categoryRtabMapper.partialUpdate(existingEntity, categoryRtabDTO);

                    return existingEntity;
                })
                .map(categoryRtabMapper::toDto)
                .orElseThrow(() -> new BlogAppServiceException("No Category entry found for id:" + categoryRtabDTO.getId(), HttpStatus.NOT_FOUND));

    }
}
