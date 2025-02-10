package fr.epsi.api_produit.repositories;

import fr.epsi.api_produit.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, String> {
}
