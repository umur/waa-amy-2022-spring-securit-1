package com.example.springsecurity.controller;


import org.springframework.web.bind.annotation.*;
import com.example.springsecurity.service.CategoryService;
import com.example.springsecurity.entity.Category;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {



    CategoryService categoryService;

    @GetMapping

    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    public void createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody Category category, @PathVariable("id") int id) {
        categoryService.updateCategory(category, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
    }
}
