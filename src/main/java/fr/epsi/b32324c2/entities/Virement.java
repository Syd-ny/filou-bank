package fr.epsi.b32324c2.entities;

import javax.persistence.Entity;

@Entity
public class Virement extends Operation {
    private String beneficiaire;
    // ... getters et setters ...

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
