package com.github.czyzowicz;

import com.github.czyzowicz.model.Address;
import com.github.czyzowicz.model.Author;
import com.github.czyzowicz.model.Book;
import com.github.czyzowicz.repository.AddressRepository;
import com.github.czyzowicz.repository.AuthorRepository;
import com.github.czyzowicz.repository.BookRepository;
import com.github.czyzowicz.repository.UserRepository;
import com.github.czyzowicz.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AfterApplication implements CommandLineRunner {

    private AddressRepository addressRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AfterApplication(AddressRepository addressRepository, AuthorRepository authorRepository, BookRepository bookRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.addressRepository = addressRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... strings) throws Exception {
        if (addressRepository.findAllBy().isEmpty() &&
            authorRepository.findAllBy().isEmpty() &&
            bookRepository.findAllBy().isEmpty()) {
       Address pokatna = createAdrress("Pokątna", "London", "UK");
       Author rowling = createAuthor("J.K.K", "Rowling", pokatna);
       Book HarryPotter = createBook("Harry Potter", rowling);}
       createUser("mike", "mike");
    }

    private Address createAdrress (String street, String city, String state){
        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        return addressRepository.save(address);
    }

    private Author createAuthor (String firstName, String lastName, Address address) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setAddress(address);
        return authorRepository.save(author);
    }

    private Book createBook (String title, Author author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    private User createUser (String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
