package org.o7planning.DevopsTp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompteSteps {
    private Compte compte;
    private String message;

    @Given("Un compte avec le numéro {string} et le solde {double}")
    public void unCompteAvecLeNumeroEtLeSolde(String numeroCompte, double solde) {
        compte = new Compte(numeroCompte, solde);
    }

    @When("Je consulte le solde du compte")
    public void jeConsulteLeSoldeDuCompte() {
        message = captureSystemOut(compte::afficherSolde);
    }

    @When("Je dépose {double} sur le compte")
    public void jeDeposeSurLeCompte(double montant) {
        captureSystemOut(() -> compte.deposer(montant));
    }

    @When("Je retire {double} du compte")
    public void jeRetireDuCompte(double montant) {
        captureSystemOut(() -> compte.retirer(montant));
    }

    @Then("Je vois le message {string}")
    public void jeVoisLeMessage(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, message.trim());
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
