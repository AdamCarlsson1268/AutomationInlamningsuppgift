Feature: Köp en produkt på hemsidan

  Scenario: Användaren köper en produkt från demowebshop
    Given jag är på hemsidan "https://demowebshop.tricentis.com/"
    When jag söker efter en produkt "Apple MacBook Pro 13-inch"
    And jag lägger produkten i varukorgen
    And jag går till varukorgen
    And jag klickar på "Checkout"
    And jag fyller i mina leveransuppgifter
    And jag väljer betalningsmetod "Betala vid leverans"
    And jag bekräftar beställningen
    Then jag ska se en bekräftelsesida med texten "Thank you for your purchase"