package com.lab.springdata.service.impl;

import com.lab.springdata.entity.Category;
import com.lab.springdata.repo.CategoryRepo;
import com.lab.springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    public void save(Category c){
        categoryRepo.save(c);
    }
    public void saveAll(List<Category> listCat){
        categoryRepo.saveAll(listCat);
    }
    public void deleteById(int id){
        categoryRepo.deleteById(id);
    }
    public Category getById(int id){
        return categoryRepo.findById(id);
    }
    public List<Category> getAll(){
        return categoryRepo.findAll();
    }
}
