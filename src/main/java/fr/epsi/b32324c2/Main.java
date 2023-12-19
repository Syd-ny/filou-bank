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

        try {
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

            // Association du compte avec les clients
            Set<Compte> comptesSet = new HashSet<>(Arrays.asList(compte));
            client1.setComptes(comptesSet);
            client2.setComptes(comptesSet);

            Client client = new Client();
            client.setNom("Martin");
            client.setPrenom("Alice");

            LivretA livretA = new LivretA();
            livretA.setSolde(2000);
            livretA.setClient(client);

            AssuranceVie assuranceVie = new AssuranceVie();
            assuranceVie.setSolde(3000);
            assuranceVie.setClient(client);

            Set<Compte> comptesClient = new HashSet<>();
            comptesClient.add(livretA);
            comptesClient.add(assuranceVie);
            client.setComptes(comptesClient);

            em.persist(client);
            em.persist(livretA);
            em.persist(assuranceVie);

            Virement virement = new Virement();
            virement.setMontant(100);
            virement.setCompte(compte);
            virement.setBeneficiaire("Beneficiaire");

            Operation operation = new Operation();
            operation.setMontant(50);
            operation.setCompte(compte);

            em.persist(virement);
            em.persist(operation);

            // Commit de la transaction
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
