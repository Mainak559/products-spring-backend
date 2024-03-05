package com.project.service;

import java.util.List;

import com.project.model.Categorie;

public interface CategorieService {
	public Categorie saveCategory(Categorie categorie);

    public List<Categorie> getAllCategories();

    public Categorie getCategoryById(Long id);

    public String deleteCategory(Long id);

    public Categorie editCategory(Categorie categorie, Long id);

}
