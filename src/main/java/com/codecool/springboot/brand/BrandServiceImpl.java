package com.codecool.springboot.brand;

import com.codecool.springboot.designer.Designer;
import com.codecool.springboot.designer.DesignerRepository;
import com.codecool.springboot.logger.LoggerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class BrandServiceImpl implements BrandService{

    private BrandRepository brandRepository;
    private DesignerRepository designerRepository;
    private Logger logger;

    public BrandServiceImpl(BrandRepository brandRepository, DesignerRepository designerRepository,
                            LoggerService loggerService) {
        this.brandRepository = brandRepository;
        this.designerRepository = designerRepository;
        this.logger = loggerService.getLogger();
    }

    @Override
    public Iterable<Brand> findAll() {
        logger.info("Brands list returned");
        return this.brandRepository.findAll();
    }

    @Override
    public Iterable<Brand> findActive() {
        return this.brandRepository.findAllByArchivedIsFalse();
    }

    @Override
    public Iterable<Brand> findArchived() {
        return this.brandRepository.findAllByArchivedIsTrue();
    }

    @Override
    public void archive(Integer id) {
        Brand brand = brandRepository.findOne( id );
        brand.setArchived( true );
        brandRepository.save(brand);
        logger.info("Brand deleted");
    }

    @Override
    public Brand findOne(Integer id ) {
        Brand brand = this.brandRepository.findBrandByIdAndArchivedIsFalse(id);
        logger.info("Brand returned");
        return brand;
    }

    @Override
    public void save(Brand brand) {
        Designer chosenDesigner = brand.getDesigner();
        Designer designer = this.designerRepository.findDesignerById(chosenDesigner.getId());
        if(designer != null) {
            brand.setDesigner(designer);
        }
        this.brandRepository.save(brand);
        logger.info("Brands saved");
    }

    @Override
    public void delete(Integer id) {
        logger.info("Brand deleted");
        this.brandRepository.delete(id);
    }

    @Override
    public void update(Integer id, Brand brand) throws IllegalAccessException {
        brand.setId(id);

        Designer designer = this.designerRepository.findDesignerById(brand.getDesigner().getId());

        if (designer != null) {
            brand.setDesigner(designer);
        } else {
            throw new IllegalArgumentException( );
        }

        Field[] fields = brand.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible( true );
            if (field.get(brand) == null ) {
                throw new IllegalArgumentException();
            }
        }
        this.brandRepository.save(brand);
        logger.info("Brand edited");
    }
}

