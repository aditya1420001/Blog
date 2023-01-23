package com.codewithadhi.blog.service;

import com.codewithadhi.blog.domain.CategoryRtab;
import com.codewithadhi.blog.service.dto.CategoryRtabDTO;

import java.util.List;

public interface CategoryRtabService {
    CategoryRtabDTO createCategory(CategoryRtabDTO categoryRtabDTO);

    void deleteCategoryById(Long categoryId);

    void deleteCategory(CategoryRtabDTO categoryRtabDTO);

    CategoryRtabDTO getCategoryById(Long id);

    List<CategoryRtabDTO> getAllCategories();

    CategoryRtab save(CategoryRtab categoryRtab);

    CategoryRtabDTO partialUpdate(CategoryRtabDTO categoryRtabDTO);

}
