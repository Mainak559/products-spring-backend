package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.model.Categorie;
import com.project.service.CategorieService;

@CrossOrigin(origins = "https://employeemanagementsystem-mainakhalder.azurewebsites.net")
@RestController
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @PostMapping("/saveCategory")
    public ResponseEntity<?> saveCategory(@RequestBody Categorie categorie) {
        try {
            return new ResponseEntity<>(categorieService.saveCategory(categorie), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        try {
            return new ResponseEntity<>(categorieService.getAllCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching categories", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/category/{id_categorie}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id_categorie") Long id) {
        try {
            return new ResponseEntity<>(categorieService.getCategoryById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching category details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteCategory/{id_categorie}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id_categorie") Long id) {
        try {
            return new ResponseEntity<>(categorieService.deleteCategory(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/editCategory/{id_categorie}")
    public ResponseEntity<?> editCategory(@RequestBody Categorie categorie, @PathVariable("id_categorie") Long id) {
        try {
            return new ResponseEntity<>(categorieService.editCategory(categorie, id), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
