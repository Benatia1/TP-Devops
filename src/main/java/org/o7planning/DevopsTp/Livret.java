package org.o7planning.DevopsTp;
public class Livret extends Compte {
    private double tauxInteret;

    public Livret(String numeroCompte, double solde, double tauxInteret) {
        super(numeroCompte, solde);
        this.tauxInteret = tauxInteret;
    }

    public void calculerInterets() {
        double interets = solde * tauxInteret;
        solde += interets;
        System.out.println("Intérêts calculés avec succès. Nouveau solde : " + solde);
    }
}
