package fr.epsi.api_produit.repositories;

import fr.epsi.api_produit.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, String> {
}
