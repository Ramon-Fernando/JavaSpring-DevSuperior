package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.CategoryDTO;
import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository repository;
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTO insert(ProductDTO dto) {

        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        for (CategoryDTO catDTO : dto.getCategories()) {

            Category cat = categoryRepository.getReferenceById(catDTO.getId());
           // Category cat = new Category();
           // cat.setId(catDTO.getId());
            entity.getCategories().add(cat);
        }

        entity = repository.save(entity);

        return new ProductDTO(entity);
    }
}
