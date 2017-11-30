package sopra.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sopra.ecom.model.Role;
import sopra.ecom.model.Utilisateur;

@Transactional
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	@Query("select u from Utilisateur u where u.login = :login AND u.motDePasse = :motDePasse")
	Utilisateur auth(@Param("login") String login, @Param("motDePasse") String motDePasse);
	
	@Query("select u from Utilisateur u where u.role = :role")
	List<Utilisateur> findAllByRole(@Param("role") Role role);

}
