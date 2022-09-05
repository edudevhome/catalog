package br.com.catalogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.catalogo.model.Category;
import br.com.catalogo.repository.CategoryRepository;

@SpringBootApplication
public class CatalogoApplication implements CommandLineRunner{ 

	@Autowired
	CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category category = new Category(1L, "Eletronics");
		Category category1 = new Category(2L, "Books");
		Category category2 = new Category(3L, "Foods");
		
		categoryRepository.save(category);
		categoryRepository.save(category1);
		categoryRepository.save(category2);
	}

}
