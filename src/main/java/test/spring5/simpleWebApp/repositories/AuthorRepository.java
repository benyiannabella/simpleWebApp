package test.spring5.simpleWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.spring5.simpleWebApp.domain.Author;


public interface AuthorRepository extends CrudRepository<Author,Long> {

}
