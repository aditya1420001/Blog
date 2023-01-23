package com.codewithadhi.blog.repositories;

import com.codewithadhi.blog.domain.CategoryRtab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRtabRepository extends JpaRepository<CategoryRtab, Long> {
}
