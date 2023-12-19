package fr.epsi.b32324c2.entities;

import javax.persistence.Entity;
import javax.persistence.Column;
import java.util.Date;
import java.util.Objects;

@Entity
public class AssuranceVie extends Compte {

    @Column(nullable = false)
    private double tauxInteret;

    @Column(nullable = false)
    private Date dateExpiration;

    public AssuranceVie() {
        // Constructeur par défaut requis par JPA
    }

    // Getters et Setters

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AssuranceVie)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        AssuranceVie that = (AssuranceVie) obj;
        return Double.compare(that.tauxInteret, tauxInteret) == 0 &&
                Objects.equals(dateExpiration, that.dateExpiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tauxInteret, dateExpiration);
    }
}
