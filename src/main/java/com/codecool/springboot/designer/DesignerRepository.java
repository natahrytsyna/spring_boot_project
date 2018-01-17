package com.codecool.springboot.designer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignerRepository extends CrudRepository<Designer, Integer> {
    Designer findDesignerById(Integer id);
    Iterable<Designer> findAllByArchivedIsFalse();
    Iterable<Designer> findAllByArchivedIsTrue();
    Designer findDesignerByIdAndArchivedIsFalse(Integer id);
}

