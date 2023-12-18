package fr.epsi.b32324c2.entities;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class AssuranceVie extends Compte {
    private Date dateFin;
    private double taux;
    // ... getters et setters ...
}
