package com.example.springsecuritybackend.controller;

import com.example.springsecuritybackend.aspect.annotation.ExecutionTime;
import com.example.springsecuritybackend.dto.CategoryDTO;
import com.example.springsecuritybackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @ExecutionTime
    public List<CategoryDTO> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public CategoryDTO getById(@PathVariable int id){
        return categoryService.getById(id);
    }

    @PostMapping
    @ExecutionTime
    public void save(@RequestBody CategoryDTO categoryDTO){
        categoryService.save(categoryDTO);
    }

    @DeleteMapping
    @ExecutionTime
    public void delete(@PathVariable int id){
        categoryService.delete(id);
    }

    @PutMapping("/{id}")
    @ExecutionTime
    public void update(@PathVariable int id, @RequestBody CategoryDTO categoryDTO){
        categoryService.update(id, categoryDTO);
    }
}
