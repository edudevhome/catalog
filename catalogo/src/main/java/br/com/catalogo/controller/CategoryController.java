package br.com.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.catalogo.model.Category;
import br.com.catalogo.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {

		 List<Category> list = categoryRepository.findAll();
//		list.add(new Category(1L, "Eletronics"));
//		list.add(new Category(2L, "Books"));
//		list.add(new Category(3L, "Foods"));

		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{idCategory}")
	public ResponseEntity<Category> findById(@PathVariable Long idCategory) {

		Category category = categoryRepository.findById(idCategory).get();
		return ResponseEntity.ok().body(category);
	}

}
