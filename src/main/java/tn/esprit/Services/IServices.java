package tn.esprit.Services;

import tn.esprit.DAO.Entities.Cinema;
import tn.esprit.DAO.Entities.Film;

import java.util.List;

public interface IServices {
    Cinema addAndUpdateCinema(Cinema c);
    List<Cinema> addAndUpdateCinemas(List<Cinema> cinemas);
    void deleteCinema(Cinema c);
    List<Cinema> findAllCinemas();
    Cinema findCinemaById(long id);

    List<Cinema> getCinemasByNom(String nom);
    List<Cinema> getCinemasByAdresse(String adresse);
    //afficher la liste des films par salle

    public void affecterSalleToCinema(long idCinema, long idSalle);
    public void affecterFilmToSalle(long idFilm, long idSalle);
    public void desaffecterSalleFromCinema(long idSalle);
    public void desaffecterFilmFromSalle(long idFilm,long idSalle);
    public List<Film> recupererFilmParSalle(long idSalle);
    public Film ajouterFilmEtAffecterAuneSalle(Film f, String nom);
}
