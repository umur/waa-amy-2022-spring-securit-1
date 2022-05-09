package com.lab.springdata.service;

import com.lab.springdata.entity.Category;
import com.lab.springdata.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    public void save(Category c);
    public void saveAll(List<Category> listCat);
    public void deleteById(int id);
    public Category getById(int id);
    public List<Category> getAll();
}
