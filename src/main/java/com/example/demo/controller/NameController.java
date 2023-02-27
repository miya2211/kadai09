package com.example.demo.controller;

import com.example.demo.entity.Name;
import com.example.demo.service.NameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NameController {

    private final NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/names")
    public List<Name> getNames() {
        return nameService.findAll();
    }

    @GetMapping("/names/{id}")
    public Name getNameById(@PathVariable("id") int id) throws Exception {
        return nameService.findById(id);
    }

    @PostMapping("/names")
    public void createName(@RequestParam("name") String name) {
        nameService.create(name);
    }

    @PutMapping("/names/{id}")
    public void updateName(@PathVariable("id") int id, @RequestParam("name") String name) throws Exception {
        nameService.update(id, name);
    }

}
