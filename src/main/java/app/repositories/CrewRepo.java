package app.repositories;

import app.models.Crew;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CrewRepo extends CrudRepository<Crew, Long> {


}
