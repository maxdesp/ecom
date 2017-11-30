package sopra.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.ecom.model.ProduitCommande;

public interface ProduitCommandeRepository extends JpaRepository<ProduitCommande, Long> {
	@Query("delete from ProduitCommande ms where ms.produit.id = :id")
	@Modifying
	void deleteAllFromProduit(@Param("id") Long id);
}
