package com.codewithadhi.blog.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryRtabDTO {

    private Long id;
    @NotNull
    @Size(max = 20)
    private String title;
    private String description;
}
