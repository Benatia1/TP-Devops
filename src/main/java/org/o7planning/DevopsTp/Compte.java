package org.o7planning.DevopsTp;

public class Compte {
    protected String numeroCompte;
    protected double solde;

    public Compte(String numeroCompte, double solde) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
    }

    public void afficherSolde() {
        System.out.println("Solde du compte " + numeroCompte + " : " + solde);
    }

    public void deposer(double montant) {
        solde += montant;
        System.out.println("Montant déposé avec succès. Nouveau solde : " + solde);
    }

    public void retirer(double montant) {
        if (montant <= solde) {
            solde -= montant;
            System.out.println("Montant retiré avec succès. Nouveau solde : " + solde);
        } else {
            System.out.println("Solde insuffisant. Opération de retrait impossible.");
        }
    }
}
