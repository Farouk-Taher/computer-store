package com.in3.task.controller;

import com.in3.task.model.ComputerListModel;
import com.in3.task.model.ComputerModel;
import com.in3.task.model.SearchCriteriaModel;
import com.in3.task.service.ComputerStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComputerStoreController {

    @Autowired
    private ComputerStoreService service;

    @CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200"})
    @GetMapping(path = "/getProducts/{page}/{size}")
    public ComputerListModel loadProductCatalog(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
        return service.loadProductCatalog(page, size);
    }

    @CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200"})
    @GetMapping(path = "/getSearchCriteria")
    public SearchCriteriaModel getSearchCriteria() {
        return service.getSearchCriteria();
    }


    @CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200"})
    @PostMapping(path = "/getSearchResult")
    @ResponseBody
    public ComputerListModel getSearchResult(@RequestBody ComputerModel computerModel) {
        return service.getSearchResult(computerModel);
    }

}
