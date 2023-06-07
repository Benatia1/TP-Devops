package org.o7planning.DevopsTp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
    private Compte compte;

    @BeforeEach
    public void setUp() {
        compte = new Compte("123456", 1000.0);
    }

    @Test
    public void testAfficherSolde() {
        String expectedOutput = "Solde du compte 123456 : 1000.0";
        Assertions.assertEquals(expectedOutput, getOutputFromMethod(() -> compte.afficherSolde()));
    }

    @Test
    public void testDeposer() {
        double montantDepot = 500.0;
        String expectedOutput = "Montant déposé avec succès. Nouveau solde : " + (compte.solde + montantDepot);
        Assertions.assertEquals(expectedOutput, captureSystemOut(() -> compte.deposer(montantDepot)));
    }

    @Test
    public void testRetirer() {
        double montantRetrait = 200.0;
        String expectedOutput = "Montant retiré avec succès. Nouveau solde : " + (compte.solde - montantRetrait);
        Assertions.assertEquals(expectedOutput, captureSystemOut(() -> compte.retirer(montantRetrait)));
    }


    @Test
    public void testRetirerSoldeInsuffisant() {
        compte.retirer(1500.0);
        String expectedOutput = "Solde insuffisant. Opération de retrait impossible.";
        Assertions.assertEquals(expectedOutput, captureSystemOut(() -> compte.retirer(1500.0)));
    }

    private String getOutputFromMethod(Runnable method) {
        return captureSystemOut(method::run);
    }

    private String captureSystemOut(Runnable code) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        code.run();
        System.setOut(originalOut);
        return outputStream.toString().trim();
    }
}
