package sopra.ecom.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.ecom.model.Categorie;
import sopra.ecom.model.Views;
import sopra.ecom.repository.CategorieRepository;

@RestController
public class CategorieController {

	@Autowired
	private CategorieRepository CategorieRepo;

	@GetMapping("/categories")
	@JsonView(Views.Categorie.class)
	public ResponseEntity<List<Categorie>> findAll() {
		return new ResponseEntity<List<Categorie>>(CategorieRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/categories/{id}")
	@JsonView(Views.Categorie.class)
	public ResponseEntity<Categorie> findOne(@PathVariable("id") Long id) {
		Categorie tmp = (Categorie) CategorieRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/categories")
	@JsonView(Views.Categorie.class)
	public ResponseEntity<Categorie> create(@RequestBody Categorie obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = CategorieRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/categories")
	@JsonView(Views.Categorie.class)
	public ResponseEntity<Categorie> update(@RequestBody Categorie obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = CategorieRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/categories/{id}")
	@JsonView(Views.Categorie.class)
	public ResponseEntity<Categorie> delete(@PathVariable("id") Long id) {
		Categorie tmp = (Categorie) CategorieRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			CategorieRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
