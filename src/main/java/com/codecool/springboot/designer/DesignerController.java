package com.codecool.springboot.designer;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/designers")
public class DesignerController {

    private DesignerService designerService;

    public DesignerController(DesignerService designerService) {
        this.designerService = designerService;
    }

    @GetMapping(path = "")
    public Iterable<Designer> showActive() {
        return this.designerService.findActive();
    }


    @GetMapping(path = "/archived")
    public Iterable<Designer> showArchived() {
        return this.designerService.findArchived();
    }


    @GetMapping(path= "/all")
    public Iterable<Designer> index() {
        return this.designerService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Designer show(@PathVariable Integer id ) {
        return this.designerService.findOne(id);
    }

    @PostMapping(path = "")
    public void create(@RequestBody Designer designer) {
        this.designerService.save(designer);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.designerService.archive(id);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Integer id,
                       @RequestBody Designer designer) throws IllegalAccessException {
        this.designerService.update(id, designer);
    }
}
