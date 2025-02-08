package com.example.api_produit.services;

import com.example.api_produit.models.Categorie;
import com.example.api_produit.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Optional<Categorie> getCategorieById(String id) {
        return categorieRepository.findById(id);
    }

    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategorie(String id, Categorie categorie) {
        if (categorieRepository.existsById(id)) {
            categorie.setId(id);
            return categorieRepository.save(categorie);
        }
        return null;  // Retourner null si la catégorie n'existe pas
    }

    public void deleteCategorie(String id) {
        categorieRepository.deleteById(id);
    }
}
