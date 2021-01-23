package BookWorm.Controller;

import BookWorm.Model.Book;
import BookWorm.Repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/books")
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @PostMapping("/books")
    void addBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable(value="id")Long id){
        Optional<Book> book = bookRepository.findById(id);
        Book bookNew = book.get();
        bookRepository.delete(bookNew);
    }

    //updateBook
}
