package fr.nromanzin.pwademo;

import fr.nromanzin.pwademo.repository.ItemRepository;
import fr.nromanzin.pwademo.repository.entity.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PwademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PwademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ItemRepository itemRepository) {
		return (args) -> {
			itemRepository.save(new Item("Melon", 1));
			itemRepository.save(new Item("Tomates", 2));
			itemRepository.save(new Item("Cerises", 5));
		};
	}

}
