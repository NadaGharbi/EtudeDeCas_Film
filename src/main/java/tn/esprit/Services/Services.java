package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.DAO.Entities.Cinema;
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
    public Cinema findCinemaById(Long id) {
        return repoCinema.findById(id).get();
    }

    @Override
    public List<Cinema> getCinemaByNom(String nom) {
        return repoCinema.getByNomContains(nom);
    }

    @Override
    public List<Cinema> getCinemaByAdresse(String adresse) {
        return repoCinema.searchCinemaByAdresseSQL(adresse);
    }
}
