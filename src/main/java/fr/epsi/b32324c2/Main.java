package fr.epsi.b32324c2;


import fr.epsi.b32324c2.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Création de l'EntityManagerFactory et de l'EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        // Transaction pour les opérations de persistences
        em.getTransaction().begin();

        // Création d'un compte de type AssuranceVie
        Compte compte = new AssuranceVie();
        compte.setNumero("123456");
        compte.setSolde(1000);

        // Création du premier client
        Client client1 = new Client();
        client1.setNom("Dupont");
        client1.setPrenom("Jean");

        // Création du second client
        Client client2 = new Client();
        client2.setNom("Durand");
        client2.setPrenom("Marie");

        List<Compte> comptesList = Arrays.asList(compte);
        Set<Compte> comptesSet = new HashSet<>(comptesList);

        Client.setComptes(comptesSet);

        // Persistance des entités
        em.persist(client1);
        em.persist(client2);
        em.persist(compte);

        // Commit de la transaction
        em.getTransaction().commit();

        // Nouvelle transaction pour les autres opérations
        em.getTransaction().begin();

        // Création d'un nouveau client avec plusieurs comptes
        Client client = new Client();
        client.setNom("Martin");
        client.setPrenom("Alice");

        LivretA livretA = new LivretA();
        livretA.setSolde(2000);
        livretA.setClient(client); // Association avec le client

        AssuranceVie assuranceVie = new AssuranceVie();
        assuranceVie.setSolde(3000);
        assuranceVie.setClient(client); // Association avec le client

        // Persistance des entités
        em.persist(client);
        em.persist(livretA);
        em.persist(assuranceVie);

        // Commit de la transaction
        em.getTransaction().commit();

        // Nouvelle transaction pour les opérations sur un compte
        em.getTransaction().begin();

        // Création et persistance d'opérations
        Virement virement = new Virement();
        virement.setMontant(100);
        virement.setCompte(compte); // Association avec un compte existant
        virement.setBeneficiaire("Beneficiaire");

        Operation operation = new Operation();
        operation.setMontant(50);
        operation.setCompte(compte); // Association avec le même compte

        em.persist(virement);
        em.persist(operation);

        // Commit de la transaction
        em.getTransaction().commit();

        // Fermeture de l'EntityManager et de l'EntityManagerFactory
        em.close();
        emf.close();

    }
}
