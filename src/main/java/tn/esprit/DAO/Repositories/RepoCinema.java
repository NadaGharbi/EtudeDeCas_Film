package tn.esprit.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.DAO.Entities.Cinema;

import java.util.List;

@Repository
public interface RepoCinema extends CrudRepository<Cinema,Long> {

    List<Cinema> getByNomContains(String nparam);

    @Query(value="select * from cinema where adresse like %?1%", nativeQuery = true)
    List<Cinema> searchCinemaByAdresseSQL(String aparam);
}
