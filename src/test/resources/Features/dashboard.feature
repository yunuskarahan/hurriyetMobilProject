Feature: Logins scenario

  @mobile
  Scenario: Select product
    When User can click profile icon.
    Then Verify that the user should be see "Profil" text.
    When User can click login button.
    Then Verify that the user should be see "Oturum açın ve kaydolun" text.(signInPage)
    When User can login.
    Then Verify that the user should be see username text.


