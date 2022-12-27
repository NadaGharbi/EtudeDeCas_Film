package tn.esprit.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.DAO.Entities.Film;

@Repository
public interface RepoFilm extends CrudRepository<Film, Long> {
}
