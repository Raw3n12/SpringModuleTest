package app.repositories;


import app.models.Officer;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepo extends CrudRepository<Officer, Long> {

    Officer findAllByUsername(String username);
}
