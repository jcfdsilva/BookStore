package com.example.w2ex4BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.w2ex4BookStore.domain.Book;
import com.example.w2ex4BookStore.domain.BookRepository;
import com.example.w2ex4BookStore.domain.Category;
import com.example.w2ex4BookStore.domain.CategoryRepository;

@SpringBootApplication
public class W2ex4BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(W2ex4BookStoreApplication.class, args);
	}
 
	@Bean
	public CommandLineRunner studentDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("fiction"));
			crepository.save(new Category("education"));
			
			brepository.save(new Book("Harry Potter", "JK R.", "2002", 10.0, crepository.findByName("fiction").get(0)));
			brepository.save(new Book("English C1", "Cambridge", "2014", 15.5, crepository.findByName("education").get(0)));	

		};
	}
}
