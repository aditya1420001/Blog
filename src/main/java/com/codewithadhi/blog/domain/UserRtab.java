package com.codewithadhi.blog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Table(name = "user_rtab")
@Getter
@Setter
public class UserRtab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_name", nullable = false, length = 127)
    private String name;
    @Column(name = "user_email", nullable = false, length = 50)
    private String email;
    @Column(name = "user_password", nullable = false, length = 50)
    private String password;
    @Column(name = "about", length = 227)
    private String about;

}
