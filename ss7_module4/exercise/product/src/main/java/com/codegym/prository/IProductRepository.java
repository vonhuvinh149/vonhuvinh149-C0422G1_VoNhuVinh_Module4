package com.codegym.prository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IProductRepository extends JpaRepository<Product,Integer> {
   Page<Product> findAllByNameContaining(String title, Pageable pageable);
}
