package test.spring5.simpleWebApp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import test.spring5.simpleWebApp.domain.Address;
import test.spring5.simpleWebApp.domain.Author;
import test.spring5.simpleWebApp.domain.Book;
import test.spring5.simpleWebApp.domain.Publisher;
import test.spring5.simpleWebApp.repositories.AddressRepository;
import test.spring5.simpleWebApp.repositories.AuthorRepository;
import test.spring5.simpleWebApp.repositories.BookRepository;
import test.spring5.simpleWebApp.repositories.PublisherRepository;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository,
                         AddressRepository addressRepository) {
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Address address = new Address("Main str., nr5", "Cob", "Main", "133456");
        Publisher publisher = new Publisher("First", address);
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain driven Design", "123123");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        publisher.getBooks().add(book);
        book.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "456654");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);
        publisher.getBooks().add(book2);
        book2.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(book2);
        publisherRepository.save(publisher);
        addressRepository.save(address);

        System.out.println("Started in Bootstrap");
        System.out.println("Publisher: " + publisher);
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Book number: " + publisher.getBooks().size());
    }
}
