package com.codewithadhi.blog.controller;

import com.codewithadhi.blog.payload.ApiResponse;
import com.codewithadhi.blog.service.CategoryRtabService;
import com.codewithadhi.blog.service.dto.CategoryRtabDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/category")
public class CategoryController {
    private final CategoryRtabService categoryRtabService;
    @PostMapping("/")
    public ResponseEntity<CategoryRtabDTO> createCategory(@Valid @RequestBody CategoryRtabDTO categoryRtabDTO){
        CategoryRtabDTO newCategoryRtabDTO = categoryRtabService.createCategory(categoryRtabDTO);
        return new ResponseEntity<CategoryRtabDTO>(newCategoryRtabDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryRtabDTO> getCategory(@PathVariable Long categoryId){

        CategoryRtabDTO categoryRtabDTO = categoryRtabService.getCategoryById(categoryId);

        return new ResponseEntity<CategoryRtabDTO>(categoryRtabDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long categoryId){
        categoryRtabService.deleteCategoryById(categoryId);
        return new ResponseEntity<ApiResponse>(
                ApiResponse
                        .builder()
                        .message("deleted successfully")
                        .success(Boolean.TRUE)
                        .build(),
                HttpStatus.OK
        );
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryRtabDTO> updateCategory(@Valid @RequestBody CategoryRtabDTO categoryRtabDTO,
                                                          @PathVariable Long categoryId){

        categoryRtabDTO.setId(categoryId);
        CategoryRtabDTO updatedCategoryRtabDto = categoryRtabService.partialUpdate(categoryRtabDTO);
        return ResponseEntity.ok(updatedCategoryRtabDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryRtabDTO>> getAllCategories(){
        List<CategoryRtabDTO> allCategories = categoryRtabService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }



}
