package tn.esprit.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.DAO.Entities.Cinema;
import tn.esprit.DAO.Entities.Film;
import tn.esprit.Services.IServices;

import java.util.List;

@RestController
@RequestMapping("details")
public class RestControllers {

    @Autowired
    IServices iservices;

    @PostMapping("addCinema")
    Cinema ajouterOuModifierCinema(@RequestBody Cinema c){
        return iservices.addAndUpdateCinema(c);
    }

    @PostMapping("addCinemas")
    List<Cinema> ajouterOuModifierCinemas(@RequestBody List<Cinema>cinemas){
        return iservices.addAndUpdateCinemas(cinemas);
    }

    @DeleteMapping("deleteCinema")
    void supprimerCinema(@RequestBody Cinema c){
        iservices.deleteCinema(c);
    }

    @GetMapping("cinemas")
    List <Cinema> afficherAllCinemas(){
        return iservices.findAllCinemas();
    }

    @GetMapping("cinema/{id}")
    Cinema afficherCinemaById(@PathVariable Long id){
        return iservices.findCinemaById(id);
    }

    @GetMapping("cinemaByNom")
    List<Cinema> afficherCinemaByNom(@RequestParam String nom){
        return iservices.getCinemasByNom(nom);
            }

            @GetMapping("cinemaByAdresse")
    List<Cinema> afficherCinemaByAdresse(@RequestParam String adresse){
        return iservices.getCinemasByAdresse(adresse);
            }

    //Méthodes d'affectation et de désaffectation

    @PutMapping("Affecter_une_salle_au_Cinema")
    void affecterSalleToCinema(@RequestParam Long idCinema,@RequestParam Long idSalle){
        iservices.affecterSalleToCinema(idCinema,idSalle);

    }

    @PutMapping("Affecter_un_Film_à_une_salle")
    void affecterFilmToSalle(@RequestParam Long idFilm,@RequestParam Long idSalle) {
        iservices.affecterFilmToSalle(idFilm,idSalle);

    }


    @PutMapping("Desaffecter_une_salle_de_Cinema")
    void desaffecterSalleFromCinema(@RequestParam Long idSalle){
        iservices.desaffecterSalleFromCinema(idSalle);

    }
    @PutMapping("Desaffecter_une_Film_d'une_Salle")
    void desaffecterFilmFromSalle(@RequestParam Long idFilm,@RequestParam Long idSalle){
        iservices.desaffecterFilmFromSalle(idFilm,idSalle);
    }

    @GetMapping("Recuperer_Film_par_Salle")
    List<Film> recupererFilmParSalle(@RequestParam Long idSalle){
        return iservices.recupererFilmParSalle(idSalle);
    }

    @PostMapping("Ajouter_Film_Et_Affecter_Salle")
    Film ajouterFilmEtAffecterAuneSalle(@RequestParam Film f,@RequestParam String nom){
        return iservices.ajouterFilmEtAffecterAuneSalle(f,nom);
    }

}
