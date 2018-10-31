Feature: Two pair Check

  Scenario: A scrambled hand with two pairs
    Given A user has five cards scrambled which contains a two pairs
      | H7 | S5 | C7 | D5 | D3 |
    Then two pairs would be detected
