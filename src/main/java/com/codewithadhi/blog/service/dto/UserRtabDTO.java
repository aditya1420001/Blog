package com.codewithadhi.blog.service.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRtabDTO {
    @Id
    private Long id;
    @NotNull
    private String name;
    @Email
    private String email;
    @NotNull
    @Size(min = 8, max = 20)
    private String password;
    private String about;
}
