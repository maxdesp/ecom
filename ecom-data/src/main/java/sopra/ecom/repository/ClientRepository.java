package sopra.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sopra.ecom.model.Client;

@Transactional
public interface ClientRepository extends JpaRepository<Client, Long>{
	@Query("select e from Client e")
	List<Client> findAll();
	
//
//	@Query("select e from Eleve e left outer join e.ressource r where (r is null or e = :eleve)")
//	List<Eleve> findAllEleveWithoutRessource(@Param("eleve") Eleve eleve);
//	
//	@Query("select f from Formateur f left join fetch f.eleves e where f.id = :id")
//	Formateur findOneFormateurWithEleves(@Param("id") Long id);
}
