package tn.esprit.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.DAO.Entities.Salle;

@Repository
public interface RepoSalle extends CrudRepository<Salle,Long> {
}
