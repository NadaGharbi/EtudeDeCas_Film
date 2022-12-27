package tn.esprit.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.Services.IServices;

@RestController
public class RestControllers {

    @Autowired
    IServices iservices;
}
