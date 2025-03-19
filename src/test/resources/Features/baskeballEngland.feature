Feature:

  Scenario: Skapa en användare
    Given Jag navigerar till "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When Jag skriver in mina uppgifter
    And Jag skickar in uppgifterna
    Then Jag får ett bekräftelsemeddelnande

  Scenario: skapa användare utan efternamn
    Given Jag navigerar till "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When Jag skriver in mina uppgifter utan efternamn
    Then Jag får ett felmeddelande om efternamn

  Scenario: Skapa användare men lösenord matchar ej
    Given Jag navigerar till "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When Jag skriver in uppgifter med olika lösen
    And Jag skickar in uppgifterna
    Then Jag får ett felmeddelande om lösenord som inte matchar


  Scenario: skapa användare utan att klicka i terms and conditions
    Given Jag navigerar till "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When Jag skriver in mina uppgifter utan att klicka i TAC
    And Jag skickar in uppgifterna
    Then Jag får ett felmeddelande om TAC
