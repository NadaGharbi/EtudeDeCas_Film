package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.DAO.Entities.Cinema;
import tn.esprit.DAO.Entities.Film;
import tn.esprit.DAO.Entities.Salle;
import tn.esprit.DAO.Repositories.RepoCinema;
import tn.esprit.DAO.Repositories.RepoFilm;
import tn.esprit.DAO.Repositories.RepoSalle;

import java.util.List;

@Service
public class Services implements IServices{

    @Autowired
    RepoCinema repoCinema;
    @Autowired
    RepoFilm repoFilm;
    @Autowired
    RepoSalle repoSalle;


    @Override
    public Cinema addAndUpdateCinema(Cinema c) {
        return repoCinema.save(c);
    }

    @Override
    public List<Cinema> addAndUpdateCinemas(List<Cinema> cinemas) {
        return (List<Cinema>) repoCinema.saveAll(cinemas);
    }

    @Override
    public void deleteCinema(Cinema c) {
        repoCinema.delete(c);
    }

    @Override
    public List<Cinema> findAllCinemas() {
        return (List<Cinema>) repoCinema.findAll();
    }

    @Override
    public Cinema findCinemaById(long id) {
        return repoCinema.findById(id).get();
    }

    @Override
    public List<Cinema> getCinemasByNom(String nom) {
        return repoCinema.getCinemaByNomContains(nom);
    }

    @Override
    public List<Cinema> getCinemasByAdresse(String adresse) {
        return repoCinema.SearchCinemasByAdresseSQL(adresse);
    }

    /*@Override
    public Film ajouterFilmEtAffecterASalle(Film f, String nom) {
        //cascade: ki tfasakh parent yetfaskhou childs// ki najouti parent najouti child//aussi modif
        //dans le parent mettre @ManyToMany(cascade = CascadeType.ALL)
        //on doit creer une keyword getByNom
        //recuperation de l'objet salle /f on l'a deja
        Salle salle = repoSalle.getSalleByNom(nom);
        //salle parent
        //film child
        //affectation child au parent
        //on peut travailler avec cascasde car a ce moment f n est pas enregistré dnc au moment de creation de salle il va creer f
        salle.getListFilms().add(f);
        repoSalle.save(salle);

        return f;
    }*/
    @Override
    public void affecterSalleToCinema(long idCinema, long idSalle){
        Cinema cinema = repoCinema.findById(idCinema).get(); //child
        Salle salle = repoSalle.findById(idSalle).get(); //parent
        salle.setCinema(cinema);
        repoSalle.save(salle);
    }
    @Override
    public void affecterFilmToSalle(long idFilm, long idSalle){
        Film film = repoFilm.findById(idFilm).get(); //child
        Salle salle = repoSalle.findById(idSalle).get(); //parent
        salle.getListFilms().add(film);
        repoSalle.save(salle);
    }

    @Override
    public void desaffecterSalleFromCinema(long idSalle) {
        //puisque salle est le parent, donc on videra la clé étrangere
        Salle salle = repoSalle.findById(idSalle).get();
        salle.setCinema(null);
        repoSalle.save(salle);
    }

    @Override
    public void desaffecterFilmFromSalle(long idFilm, long idSalle) {
        Film film = repoFilm.findById(idFilm).get();
        Salle salle = repoSalle.findById(idSalle).get(); //parent
        salle.getListFilms().remove(film);
        repoSalle.save(salle);
    }

    @Override
    public List<Film> recupererFilmParSalle(long idSalle) {
        return repoFilm.recupererFilmBySalleSQL(idSalle);
    }

    @Override
    public Film ajouterFilmEtAffecterAuneSalle(Film f, String nom) {
        Salle salle = repoSalle.getSalleByNom(nom); //parent
                /* Affectation du child film a la salle ,on a utilisé cette façon car on utilise cascade on affecte un film
        //à la salle  il sera ajouté automatiquement  dans table film */
        salle.getListFilms().add(f);
        repoSalle.save(salle);

        return f;


    }


}
