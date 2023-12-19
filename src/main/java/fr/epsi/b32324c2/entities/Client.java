package fr.epsi.b32324c2.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;

    // Adresse comme attribut intégré
    @Embedded
    private Adresse adresse;

    // Relation avec Banque
    @ManyToOne
    @JoinColumn(name = "banque_id")
    private Banque banque;

    // Relation avec Compte
    @OneToMany(mappedBy = "client")
    private Set<Compte> comptes;

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }
}

