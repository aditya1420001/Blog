package com.codewithadhi.blog.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryRtabDTO {

    private Long id;
    @NotBlank(message = "Category title cannot be null")
    @Size(max = 20)
    private String title;
    private String description;
}
