Feature: Todolist

  Background:
  Given I have a todolist

  Scenario Outline: Add task
    When User adds new stuff to list with description "<description>"
    Then The todolist contains task "1. [ ] <expected>"

    Examples:
      | description | expected |
      | Städa       | Städa    |
      | Handla      | Handla   |
      | Laga mat    | Laga mat |
      | Raka sig    | Raka sig |

  Scenario: Mark task as done
      Given User adds new stuff to list with description "Städa"
      When I mark the task as done
      Then the task is displayed as done

  Scenario: Check number of tasks
    When User adds new stuff to list with description "Städa"
    And User adds new stuff to list with description "handla"
    And User adds new stuff to list with description "Laga mat"
    And User adds new stuff to list with description "Raka sig"
    Then Tasks in the todolist should align 4

  Scenario: Completed tasks
    When User adds new stuff to list with description "Städa"
    And User adds new stuff to list with description "handla"
    And User adds new stuff to list with description "Laga mat"
    And User adds new stuff to list with description "Raka sig"
    And I mark the task as done
    Then Completed tasks should be 1


