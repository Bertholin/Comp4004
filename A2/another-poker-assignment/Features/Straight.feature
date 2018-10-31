Feature: Straight Check

  Scenario: A Scrambled Straight
    Given A user has five cards all in order
      | C3 | D2 | H6 | H5 | S4 |
    Then A straight would be detected
