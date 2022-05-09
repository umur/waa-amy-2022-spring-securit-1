package com.lab.springdata.controller;

import com.lab.springdata.entity.Category;
import com.lab.springdata.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Category getById(@PathVariable int id){
        return  categoryService.getById(id);
    }
    @PostMapping
    public void save(@RequestBody Category u){
        categoryService.save(u);
    }
    @PostMapping(params = "save=all")
    public void saveAll(@RequestBody List<Category> ul){
        categoryService.saveAll(ul);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryService.deleteById(id);
    }
}
