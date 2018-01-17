package com.codecool.springboot.brand;

import com.codecool.springboot.designer.Designer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Brand getBrandByName(String firstName);
    Iterable<Brand> findAllByArchivedIsFalse();
    Iterable<Brand> findAllByArchivedIsTrue();
    Brand findBrandByIdAndArchivedIsFalse(Integer id);
    Brand findBrandByNameAndArchivedIsTrue(String name);

}
