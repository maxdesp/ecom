package sopra.ecom;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sopra.ecom.model.Adresse;
import sopra.ecom.model.Categorie;
import sopra.ecom.model.Client;
import sopra.ecom.model.Commande;
import sopra.ecom.model.Produit;
import sopra.ecom.model.Role;
import sopra.ecom.model.Statut;
import sopra.ecom.model.Utilisateur;
import sopra.ecom.repository.CategorieRepository;
import sopra.ecom.repository.ClientRepository;
import sopra.ecom.repository.CommandeRepository;
import sopra.ecom.repository.ProduitRepository;
import sopra.ecom.repository.UtilisateurRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class FormationTestSpring {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private UtilisateurRepository userRepository;
	@Autowired
	private CategorieRepository catRepository;
	@Autowired
	private ProduitRepository prodRepository;
	@Autowired
	private CommandeRepository comRepository;

	@Test
	public void client() {
		
		Utilisateur user1 = new Utilisateur();
		user1.setLogin("max");
		user1.setMotDePasse("password");
		user1.setRole(Role.ADMIN_CAT);
		userRepository.save(user1);
		Utilisateur user = userRepository.findOne(user1.getId());
		
		Client client1 = new Client("Durand", "Jean", "#E42", "jean@durand.com", "0664398393");
		Adresse adr = new Adresse("26 avenue Gustave Eiffel", "33700", "Mérignac");
		
		client1.setAdrFacturation(adr);
		client1.setUtilisateur(user);
		System.out.println(client1);
		
		clientRepository.save(client1);	
//		clientRepository.save(client1);
		
	
		

	}
	
	@Test
	public void produit() {
		
		Categorie cat = new Categorie();
		
		cat.setNom("informatique");
		cat.setDescription("Matériel informatique");
		catRepository.save(cat);
		
		
		Produit prod = new Produit("asus", 12L);
		prod.setPrix(499D);
		prod.setDescription("ordinateur portable asus");
		prod.setCategorie(cat);
		prodRepository.save(prod);
		
		Produit prod2 = new Produit("mac", 12L);
		prod2.setPrix(999D);
		prod2.setDescription("ordinateur portable mac");
		prod2.setCategorie(cat);
		prodRepository.save(prod2);

		Commande com = new Commande();
		
		ArrayList<Produit> produits = new ArrayList<>();
		produits.add(prod);
		produits.add(prod2);
		com.setNumero("COMMANDE12");
		System.out.println(prod.getPrix());
		com.setPrixTotal(prod.getPrix() + prod2.getPrix());
		System.out.println(com.getPrixTotal());
		com.setDtCommande(new Date());
		com.setCommentaires("commentaire commande");
		com.setStatut(Statut.PANIER);
		comRepository.save(com);
	}

}
