package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Categorie;
import com.project.repository.CategorieRepository;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepo;

    @Override
    public Categorie saveCategory(Categorie categorie) {
        return categorieRepo.save(categorie);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepo.findAll();
    }

    @Override
    public Categorie getCategoryById(Long id) {
        return categorieRepo.findById(id).orElse(null);
    }

    @Override
    public String deleteCategory(Long id) {
        Categorie category = categorieRepo.findById(id).orElse(null);

        if (category != null) {
            categorieRepo.delete(category);
            return "Category Deleted Successfully";
        }
        return "Category not found";
    }

    @Override
    public Categorie editCategory(Categorie c, Long id) {
        Categorie oldCategory = categorieRepo.findById(id).orElse(null);

        if (oldCategory != null) {
            oldCategory.setNom_categorie(c.getNom_categorie());
            // Set other attributes as needed

            return categorieRepo.save(oldCategory);
        }
        return null;
    }
}
