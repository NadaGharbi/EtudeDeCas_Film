package tn.esprit.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.DAO.Entities.Film;

import java.util.List;

@Repository
public interface RepoFilm extends CrudRepository<Film, Long> {
    //2eme methode
    //bch yefhem li ena nikhdem b keyword lezem tebda b get wala found
    //je ne peux pas travailler avec keyword ni jpql car c une relation uni car de film je n'ai pas d'attribut pr passer a salle
    //List<Film> getFilmsBy

    //3eme methode en sql
    @Query(value = "select f from Film"+
            "JOIN salle_list_films sf ON f.id=sf.list_films_id"+
            "JOIN salle s ON s.id=sf.salle_id"+
            "WHERE s.id=?1", nativeQuery = true)
    List<Film> recupererFilmBySalleSQL(long idSalle); //pr les param on travaille avec ordre ou avec @param, on ne met rien dnc avec ordre
}
