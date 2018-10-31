Feature: Pair Check

  Scenario: A scrambled hand with one pair
    Given A user has five cards scrambled which contains a pair
      | H9 | S5 | C7 | D5 | D3 |
    Then A pair would be detected
