package com.sparta.delivery.product;

import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Page<Product> findAll(@Nullable Pageable pageable);

    Page<Product> findByProductNameContaining(String search, Pageable pageable);
}

