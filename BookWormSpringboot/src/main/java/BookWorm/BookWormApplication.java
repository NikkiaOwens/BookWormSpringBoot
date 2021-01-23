package BookWorm;

import BookWorm.Model.Book;
import BookWorm.Repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BookWormApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookWormApplication.class, args);
	}

	@Bean
	CommandLineRunner init(BookRepository bookRepository) {
		return args -> {
//			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//				Book book = new Book(name, name.toLowerCase() + "@domain.com");
//				bookRepository.save(book);
			String[] titles = {"The Great Gatsby", "Harry Potter", "The Host", "Recursion", "The Overstay"};
			String[] authorNames = {"F. Scott Fitzgerald", "J.K. Rowling", "Stephanie Myer", "Blake Crouch", "Richard Powers"};

			for (int i = 0; i < titles.length; i++) {
				Book book = new Book(titles[i], authorNames[i]);
				bookRepository.save(book);
			}


			bookRepository.findAll().forEach(System.out::println);
			//};
		};
	}
}
