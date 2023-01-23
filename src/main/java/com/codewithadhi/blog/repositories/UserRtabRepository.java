package com.codewithadhi.blog.repositories;


import com.codewithadhi.blog.domain.UserRtab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRtabRepository extends JpaRepository<UserRtab, Long> {
}

