package fr.epsi.b32324c2.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
    private String rue;
    private String ville;
    private String codePostal;

    // Getters et setters

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}

