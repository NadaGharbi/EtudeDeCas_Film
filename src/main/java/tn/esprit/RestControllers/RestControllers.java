package tn.esprit.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.DAO.Entities.Cinema;
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
        return iservices.getCinemaByNom(nom);
            }

            @GetMapping("cinemaByAdresse")
    List<Cinema> afficherCinemaByAdresse(@RequestParam String adresse){
        return iservices.getCinemaByAdresse(adresse);
            }

}
