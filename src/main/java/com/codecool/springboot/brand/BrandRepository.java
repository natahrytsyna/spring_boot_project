package com.codecool.springboot.brand;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Iterable<Brand> findAllByArchivedIsFalse();
    Iterable<Brand> findAllByArchivedIsTrue();
    Brand findBrandByIdAndArchivedIsFalse(Integer id);
}
