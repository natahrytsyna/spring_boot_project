package com.codecool.springboot.brand;

public interface BrandService {

    Iterable<Brand> findAll();

    Iterable<Brand> findArchived();

    Iterable<Brand> findActive();

    Brand findOne(Integer id);

    void save(Brand brand);

    void delete(Integer id);

    void archive(Integer id);

    void update(Integer id, Brand brand) throws IllegalAccessException;

}
