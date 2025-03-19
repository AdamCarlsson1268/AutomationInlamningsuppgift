Feature:

  Scenario Outline: Add two number
    Given I have two number <first> and <second>
    When I add the two numbers
    Then I get the result <expected>
  Examples:
      | first | second | expected |
      | 10.2  | 20.5   | 30.7     |




