package br.com.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.catalogo.model.Product;
import br.com.catalogo.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository ProductRepository;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {

		 List<Product> list = ProductRepository.findAll();
//		list.add(new Product(1L, "Eletronics"));
//		list.add(new Product(2L, "Books"));
//		list.add(new Product(3L, "Foods"));

		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{idProduct}")
	public ResponseEntity<Product> findById(@PathVariable Long idProduct) {

		Product Product = ProductRepository.findById(idProduct).get();
		return ResponseEntity.ok().body(Product);
	}

}
