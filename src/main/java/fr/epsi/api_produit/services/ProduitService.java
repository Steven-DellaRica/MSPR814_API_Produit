package fr.epsi.api_produit.services;

import fr.epsi.api_produit.models.Produit;
import fr.epsi.api_produit.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepo;

    public List<Produit> getAllProduits() {
        return produitRepo.findAll();
    }

    public Optional<Produit> getProduitById(String id) {
        return produitRepo.findById(id);
    }

    public Produit addProduit(Produit produit) {
        return produitRepo.save(produit);
    }

    public Produit updateProduit(String id, Produit produit) {
        if (produitRepo.existsById(id)) {
            produit.setId(id);
            return produitRepo.save(produit);
        }
        return null;  // Retourner null si le produit n'existe pas
    }

    public void deleteProduit(String id) {
        produitRepo.deleteById(id);
    }
}
