package fr.epsi.b32324c2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;


@Entity
public class LivretA extends Compte {

    @Column(nullable = false)
    private double taux;

    public LivretA() {

    }

    // Getters et Setters

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LivretA livretA = (LivretA) obj;
        return Double.compare(livretA.taux, taux) == 0;
    }


    @Override
    public int hashCode() {
        return Objects.hash(taux);
    }

}
