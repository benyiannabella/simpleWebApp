package test.spring5.simpleWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.spring5.simpleWebApp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {


}
