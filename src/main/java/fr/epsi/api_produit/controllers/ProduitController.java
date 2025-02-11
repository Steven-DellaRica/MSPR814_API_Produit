package fr.epsi.api_produit.controllers;

import fr.epsi.api_produit.models.Produit;
import fr.epsi.api_produit.services.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable String id) {
        Optional<Produit> produit = produitService.getProduitById(id);
        return produit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Produit> addProduit(@RequestBody Produit produit) {
        Produit savedProduit = produitService.addProduit(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable String id, @RequestBody Produit produit) {
        System.out.println(produit);
        Optional<Produit> updatedProduit = produitService.updateProduit(id, produit);
        return updatedProduit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable String id) {
        produitService.deleteProduit(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
