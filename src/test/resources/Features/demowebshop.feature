Feature: Test demowebshop

  Scenario Outline: Navigera till kategorier på demowebshop
    Given Befinner mig på demowebshopsidan
    When Klickar på "<category>"
    Then Då ser man en lista med produkter på sidan"<expectedTitle>"

    Examples:
      | category          | expectedTitle     |
      | Books             | Books             |
      | Apparel & Shoes   | Apparel & Shoes   |
      | Electronics       | Electronics       |
      | Computers         | Computers         |
      | Digital downloads | Digital downloads |
      | Jewelry           | Jewelery          |
      | Gift Cards        | Gift Cards        |



