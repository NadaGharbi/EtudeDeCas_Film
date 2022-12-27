package tn.esprit.DAO.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cinema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nom;

    @Column(length = 50) // controle de saisie sur la longueur
    String adresse;

    @Column(unique = true) // Unicité dans la base
    Integer telephone;

    @OneToMany(mappedBy = "cinema")
    List<Salle> ListSalles;
}
