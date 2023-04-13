package com.alten.products.services.impl;

import com.alten.products.dao.ProductsDao;
import com.alten.products.models.Products;
import com.alten.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsDao productsDao;

    /*public ProductsServiceImpl(ProductsDao theproductsDao) {
        productsDao = theproductsDao;
    }

    @Transactional
    public List<Products> find(String term, String sort, int page, int pageSize) {

        Pageable paging = (Pageable) PageRequest.of(page, pageSize, Sort.by(sort));

        Page<Products>  pageResult = null;

        if(term != "") {

            pageResult = productsDao.findAll((org.springframework.data.domain.Pageable) paging);
        } else {
            pageResult = productsDao.findByName(term, paging);
        }

        return pageResult.toList();
    }*/

    @Transactional
    public List<Products> findAll() {


        List<Products>  Result = null;

        Result = (List<Products>) productsDao.findAll();

        return Result;
    }


    @Transactional
    public List<Products> add(Products product) {
        Products products = productsDao.save(product);
        return productsDao.findAll();
    }
    @Transactional
    public List<Products> update(Products product) {

        Long id = product.getId();
        Optional<Products> oldProduct = productsDao.findById(id);
        if(!oldProduct.isEmpty()) {
            productsDao.save(product);
        }
        return productsDao.findAll();
    }

    @Transactional
    public List<Products> delete(Long id) {
        Optional<Products> oldProduct = productsDao.findById(id);
        if(!oldProduct.isEmpty()) {
            productsDao.deleteById(id);
        }

        return productsDao.findAll();
    }


    public List<Products> deleteMultiple(List<Long> ids) {
        boolean cond = true;
        for(Long id : ids) {
            Optional<Products> oldProduct = productsDao.findById(id);
            if(!oldProduct.isEmpty()) {
                productsDao.deleteById(id);
            }
        }

        return productsDao.findAll();
    }
}
