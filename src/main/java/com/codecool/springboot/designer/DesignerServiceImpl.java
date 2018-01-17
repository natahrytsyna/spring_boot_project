package com.codecool.springboot.designer;

import com.codecool.springboot.logger.LoggerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class DesignerServiceImpl implements DesignerService {

    private DesignerRepository designerRepository;
    private Logger logger;

    public DesignerServiceImpl(DesignerRepository designerRepository, LoggerService loggerService) {
        this.logger = loggerService.getLogger();
        this.designerRepository = designerRepository;
    }

    @Override
    public Iterable<Designer> findAll() {
        logger.info("Designers list returned");
        return this.designerRepository.findAll();
    }

    @Override
    public Iterable<Designer> findActive() {
        return this.designerRepository.findAllByArchivedIsFalse();
    }

    @Override
    public Iterable<Designer> findArchived() {
        return this.designerRepository.findAllByArchivedIsTrue();
    }

    @Override
    public Designer findOne(Integer id ) {
        Designer designer = this.designerRepository.findDesignerByIdAndArchivedIsFalse(id);
        logger.info("Designer returned");
        return designer;
    }

    @Override
    public void save(Designer designer) {
        this.designerRepository.save(designer);
        logger.info("Designer save");
    }

    @Override
    public void delete(Integer id) {
        this.designerRepository.delete(id);
    }

    @Override
    public void update(Integer id, Designer designer) {
        designer.setId(id);
        if(designer.isArchived()) {
            logger.error("You can't access archived data");
        } else {
            designer.setId(id);
            this.designerRepository.save(designer);
            logger.info("Designer updated");
        }
    }

    @Override
    public void archive(Integer id) {
        Designer designer = designerRepository.findOne( id );
        designer.setArchived( true );
        designerRepository.save(designer);
        logger.info("Designer deleted");
    }
}
