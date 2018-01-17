package com.codecool.springboot.designer;

import org.springframework.stereotype.Service;

@Service
public interface DesignerService {

    Iterable<Designer> findAll();

    Iterable<Designer> findActive();

    Iterable<Designer> findArchived();

    Designer findOne( Integer id);

    void save( Designer designer);

    void delete(Integer id);

    void update(Integer id, Designer designer);

    void archive(Integer id);
}
