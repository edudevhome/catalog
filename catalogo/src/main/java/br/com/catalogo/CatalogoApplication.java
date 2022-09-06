package br.com.catalogo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.catalogo.model.Category;
import br.com.catalogo.model.Product;
import br.com.catalogo.repository.CategoryRepository;
import br.com.catalogo.repository.ProductRepository;

@SpringBootApplication
public class CatalogoApplication implements CommandLineRunner{ 

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		
		
		Category category = new Category(null, "Eletronics");
		Category category1 = new Category(null, "Books");
		Category category2 = new Category(null, "Foods");
		
		Product p1 = new Product(null, "TV", 2200.00, category);
		Product p2 = new Product(null, "Domain Driven Design", 120.00, category1);
		Product p3 = new Product(null, "PS5", 2800.00, category);
		Product p4 = new Product(null, "Docker", 100.00, category1);
		Product p5 = new Product(null, "Pão kg", 10.00, category2);
		Product p6 = new Product(null, "Stella Artois", 35.00, category2);
		
		category.getProducts().addAll(Arrays.asList(p1, p3));
		category1.getProducts().addAll(Arrays.asList(p2, p4));
		category2.getProducts().addAll(Arrays.asList(p5, p6));
		
		
		categoryRepository.save(category);
		categoryRepository.save(category1);
		categoryRepository.save(category2);
		
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
		productRepository.save(p5);
		productRepository.save(p6);
	}

}
