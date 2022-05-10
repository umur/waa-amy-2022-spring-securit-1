package edu.miu.springdata.service.impl;

import edu.miu.springdata.aspect.ExecutionTime;
import edu.miu.springdata.dto.ProductDto;
import edu.miu.springdata.entity.bidirectional.Product;
import edu.miu.springdata.repository.ProductRepository;
import edu.miu.springdata.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @ExecutionTime
    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return modelMapper.map(productRepository.save(product), ProductDto.class);
    }

    @Override
    public List<ProductDto> findAll() {
        var products = productRepository.findAll();
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(products,listType);
    }

    @Override
    public ProductDto findById(Long id) {
        var product  = productRepository.findById(id);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }
    @ExecutionTime
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThan(Double minPrice) {
        var products = productRepository.findAllByPriceGreaterThan(minPrice);
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(products,listType);
    }

    @Override
    public List<ProductDto> findByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice) {
        var products = productRepository.findByCategoryNameAndPriceLessThan(categoryName,maxPrice);
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(products,listType);
    }

    @ExecutionTime
    @Override
    public List<ProductDto> findAllByNameContains(String keyword) {
        var products = productRepository.findAllByNameContains(keyword);
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(products,listType);
    }
}
