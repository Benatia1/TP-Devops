Feature: Gestion du compte
  Scenario: Afficher le solde du compte
    Given Un compte avec le numéro "123456" et le solde "1000.0"
    When Je consulte le solde du compte
    Then Je vois le message "Solde du compte 123456 : 1000.0"

  Scenario: Déposer de l'argent sur le compte
    Given Un compte avec le numéro "123456" et le solde "1000.0"
    When Je dépose "500.0" sur le compte
    Then Je vois le message "Montant déposé avec succès. Nouveau solde : 1500.0"

  Scenario: Retirer de l'argent du compte avec solde suffisant
    Given Un compte avec le numéro "123456" et le solde "1000.0"
    When Je retire "200.0" du compte
    Then Je vois le message "Montant retiré avec succès. Nouveau solde : 800.0"

  Scenario: Retirer de l'argent du compte avec solde insuffisant
    Given Un compte avec le numéro "123456" et le solde "1000.0"
    When Je retire "1500.0" du compte
    Then Je vois le message "Solde insuffisant. Opération de retrait impossible."
