package com.alten.products.controllers;

import com.alten.products.models.Products;
import com.alten.products.services.ProductsService;
import com.alten.products.services.impl.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductsController {

    @Autowired
    private ProductsServiceImpl productsServiceImpl;

    /*@GetMapping("/")
    public Page<Products> findAll(Pageable p, @PathVariable String sort, @PathVariable String term) {
        return (Page<Products>) productsServiceImpl.find(sort, term, p.getPageNumber(), p.getPageSize());
    } */

    @GetMapping("/")
    public List<Products> findAll() {
        return (List<Products>) productsServiceImpl.findAll();
    }

    @PostMapping("/")
    public List<Products> add(@RequestBody  Products product) {
        return (List) productsServiceImpl.add(product);
    }

    @PutMapping("/")
    public List<Products> update(@RequestBody Products products) {
        return (List) productsServiceImpl.update(products);
    }

    @PostMapping("/delete")

    public List<Products> update(@RequestBody List<Long> ids) {
        return (List) productsServiceImpl.deleteMultiple(ids);
    }


}
