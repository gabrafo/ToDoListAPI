package com.br.emakers.APItest.repository;

import com.br.emakers.APItest.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Métodos que ajudam a manipular as tabelas
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}