package com.example.springsecuritybackend.service.impl;

import com.example.springsecuritybackend.dto.ProductDTO;
import com.example.springsecuritybackend.domain.Product;
import com.example.springsecuritybackend.repository.ProductRepository;
import com.example.springsecuritybackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//    private CategoryServiceImpl categoryService;
    private final ModelMapper modelMapper;

    @Override
    public void save(ProductDTO productDTO) {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        productDTO.setUser( principal.);
        productRepository.save(modelMapper.map(productDTO, Product.class));
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(int id, ProductDTO productDTO) {
        var p = productRepository.findById(id);
        if (p.isPresent()){
            p.get().setCategory(productDTO.getCategory());
            p.get().setName(productDTO.getName());
            p.get().setPrice(productDTO.getPrice());
            p.get().setRating(productDTO.getRating());
//            p.get().setUser(modelMapper.map(securityContextHolder, User.class));
            productRepository.save(p.get());
        }
    }

    @Override
    public ProductDTO getById(int id) {
        var p = productRepository.findById(id);
        return p.isPresent() ? modelMapper.map(p.get(), ProductDTO.class) : null;
    }

    @Override
    public List<ProductDTO> getAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(c -> modelMapper.map(c, ProductDTO.class))
                .toList();
    }

    @Override
    public List<ProductDTO> findAllByNameEquals(String name){
        return  StreamSupport.stream(productRepository.findAllByNameEquals(name).spliterator(), false)
                .map(c -> modelMapper.map(c, ProductDTO.class))
                .toList();
    }

    @Override
    public List<ProductDTO> findAllByPriceGreaterThan(double minPrice){
        return  StreamSupport.stream(productRepository.findAllByPriceGreaterThan(minPrice).spliterator(), false)
                .map(c -> modelMapper.map(c, ProductDTO.class))
                .toList();
    }

    @Override
    public List<ProductDTO> findAllByCategoryAndPriceIsLessThan(String category, double price){
        return  StreamSupport.stream(productRepository.findAllByCategory_NameAndPriceIsLessThan(category, price).spliterator(), false)
                .map(c -> modelMapper.map(c, ProductDTO.class))
                .toList();
    }

}
