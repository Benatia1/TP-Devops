package org.o7planning.DevopsTp;
public class Main {
    public static void main(String[] args) {
        Compte compte1 = new Compte("123456", 1000.0);
        compte1.afficherSolde(); // Affiche : Solde du compte 123456 : 1000.0

        compte1.deposer(500.0); // Affiche : Montant déposé avec succès. Nouveau solde : 1500.0
        compte1.retirer(200.0); // Affiche : Montant retiré avec succès. Nouveau solde : 1300.0
        compte1.retirer(1500.0); // Affiche : Solde insuffisant. Opération de retrait impossible.

        Livret livret1 = new Livret("789012", 2000.0, 0.05);
        livret1.afficherSolde(); // Affiche : Solde du compte 789012 : 2000.0

        livret1.calculerInterets(); // Affiche : Intérêts calculés avec succès. Nouveau solde : 2100.0
        livret1.deposer(1000.0); // Affiche : Montant déposé avec succès. Nouveau solde : 3100.0
    }
}
