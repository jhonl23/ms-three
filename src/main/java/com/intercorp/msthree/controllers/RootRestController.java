package com.intercorp.msthree.controllers;

import com.intercorp.msthree.models.Root;
import com.intercorp.msthree.service.IRootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"https://jhonl23.github.io","http://localhost:4200/"}, methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/api/roots")
public class RootRestController {

    @Autowired
    private IRootService rootService;

    @GetMapping("/page/{page}")
    public Page<Root> index(@PathVariable Integer page) throws Exception {
        Pageable pageable = PageRequest.of(page,5);
        return this.rootService.listAll(pageable);
    }

    @PostMapping("/find-by-parameters/page/{page}")
    public Page<Root> findByParameters(@PathVariable Integer page, @RequestBody(required = false) String textSearch) throws Exception {
        return this.rootService.findByParameters(textSearch, page, 5);
    }

}
