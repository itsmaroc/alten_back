package com.alten.products.dao;

import com.alten.products.models.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;

@CrossOrigin(origins = "*")
public interface ProductsDao extends JpaRepository<Products, Long> {


    //Page<Products> findAll(String sort, Pageable paging);

    //Page<Products> findByName(String term, Pageable paging);
}
