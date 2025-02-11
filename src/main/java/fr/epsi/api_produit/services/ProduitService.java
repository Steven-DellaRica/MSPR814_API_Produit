package fr.epsi.api_produit.services;

import fr.epsi.api_produit.models.Categorie;
import fr.epsi.api_produit.models.Produit;
import fr.epsi.api_produit.repositories.CategorieRepository;
import fr.epsi.api_produit.repositories.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private final ProduitRepository produitRepo;
    private final CategorieRepository categorieRepo;

    public ProduitService(ProduitRepository produitRepo, CategorieRepository categorieRepo, ProduitRepository produitRepository) {
        this.produitRepo = produitRepo;
        this.categorieRepo = categorieRepo;
    }

    public List<Produit> getAllProduits() {
        return produitRepo.findAll();
    }

    public Optional<Produit> getProduitById(String id) {
        return produitRepo.findById(id);
    }

    public Produit addProduit(Produit produit) {
        if (produit.getCategorie() != null && produit.getCategorie().getId() != null) {
            Categorie categorie = categorieRepo.findById(produit.getCategorie().getId()).orElse(null);
            produit.setCategorie(categorie);
        }
        return produitRepo.save(produit);
    }

    public Optional<Produit> updateProduit(String id, Produit produitDetails) {
        return produitRepo.findById(id).map(produit -> {
            produit.setNom(produitDetails.getNom());
            produit.setPrix(produitDetails.getPrix());
            if(produitDetails.getCategorie() != null && produitDetails.getCategorie().getId() != null) {
                Categorie categorie = categorieRepo.findById(produitDetails.getCategorie().getId()).orElse(null);
                produit.setCategorie(categorie);
            }
            System.out.println("Nom de la catégorie du produit : " + produit.getCategorie().getNom());
            return produitRepo.save(produit);
        });
    }

    public void deleteProduit(String id) {
        produitRepo.deleteById(id);
    }
}
