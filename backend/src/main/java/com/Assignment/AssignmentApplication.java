package com.Assignment;

import com.Assignment.Entity.Product;
import com.Assignment.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(ProductRepository pr) {
		return args -> {
			pr.save(new Product("Mars Bar Chocolate 33G", 127.00));
			pr.save(new Product("Anchor Instant Milk Powder 400G", 345.00));
			pr.save(new Product("Anchor Uht Milk 1L", 220.00));
			pr.save(new Product("Bon Aroma Classic Instant Coffee 200G", 1390.00));
			pr.save(new Product("Coca Cola Bottle 400Ml", 100.00));
			pr.save(new Product("Daily Milk Vanila 200Ml", 50.00));
			pr.save(new Product("Harischandra Coffee 100G", 210.00));
			pr.save(new Product("Maltesers Chocolate 37G", 280.00));
			pr.save(new Product("Md Chillie Garlic Sauce 400G", 340.00));
			pr.save(new Product("Md Jam Low Sugar Wood Apple 330G", 300.00));
			pr.save(new Product("Md Jelly Crystals Raspberry 100G", 85.00));
			pr.save(new Product("Motha Corn Flour 100G", 75.00));
			pr.save(new Product("Axe Body Spray Click 150Ml", 700.00));
			pr.save(new Product("Black Knight Dark Night Cologne 100Ml", 560.00));

			pr.findAll().forEach(System.out::println);

		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:9000");
			}
		};
	}
}

