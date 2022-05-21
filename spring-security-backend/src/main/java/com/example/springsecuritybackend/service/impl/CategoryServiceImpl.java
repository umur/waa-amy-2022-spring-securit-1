package com.example.springsecuritybackend.service.impl;

import com.example.springsecuritybackend.dto.CategoryDTO;
import com.example.springsecuritybackend.domain.Category;
import com.example.springsecuritybackend.repository.CategoryRepository;
import com.example.springsecuritybackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(CategoryDTO categoryDTO) {
        categoryRepository.save(modelMapper.map(categoryDTO, Category.class));
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void update(int id, CategoryDTO categoryDTO) {
        var r = categoryRepository.findById(id);
        if (r.isPresent()){
            r.get().setName(categoryDTO.getName());
            categoryRepository.save(r.get());
        }
    }

    @Override
    public CategoryDTO getById(int id) {
        var c = categoryRepository.findById(id);
        return c.isPresent() ? modelMapper.map(c.get(), CategoryDTO.class) : null;
    }

    @Override
    public List<CategoryDTO> getAll() {
        return StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .map(u -> modelMapper.map(u, CategoryDTO.class))
                .collect(Collectors.toList());
    }

//    @Override
//    public CategoryDTO findFirstBy(String name){
//        return modelMapper.map(categoryRepository.findFirstBy(name), CategoryDTO.class);
//    }
}
