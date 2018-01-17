package com.codecool.springboot.brand;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/brands")
public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService) { this.brandService = brandService;
    }

    @GetMapping(path= "/all")
    public Iterable<Brand> index() {
        return this.brandService.findAll();
    }

    @GetMapping(path = "")
    public Iterable<Brand> showActive() {
        return this.brandService.findActive();
    }

    @GetMapping(path = "/archived")
    public Iterable<Brand> showArchived() {
        return this.brandService.findArchived();
    }

    @GetMapping(path = "/{id}")
    public Brand show(@PathVariable Integer id ) {
        return this.brandService.findOne(id);
    }

    @PostMapping(path = "")
    public void create(@RequestBody Brand brand) {
        this.brandService.save(brand);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.brandService.archive(id);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Integer id, @RequestBody Brand brand) throws IllegalAccessException {
        this.brandService.update(id, brand);
    }
}
