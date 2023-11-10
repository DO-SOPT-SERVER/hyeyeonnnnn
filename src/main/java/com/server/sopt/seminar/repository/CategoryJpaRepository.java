package com.server.sopt.seminar.repository;

import com.server.sopt.seminar.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Short> {
}