package tn.esprit.Services;

import tn.esprit.DAO.Entities.Cinema;

import java.util.List;

public interface IServices {
    Cinema addAndUpdateCinema(Cinema c);
    List<Cinema> addAndUpdateCinemas(List<Cinema> cinemas);
    void deleteCinema(Cinema c);
    List<Cinema> findAllCinemas();
    Cinema findCinemaById(Long id);

    List<Cinema> getCinemaByNom(String nom);
    List<Cinema> getCinemaByAdresse(String adresse);
}
