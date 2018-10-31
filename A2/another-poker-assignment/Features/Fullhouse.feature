Feature: Fullhouse Check

  Scenario: A scrambled FullHouse
    Given A user has five cards scrambled which contains a pair and triple
      | H5 | S5 | C3 | D5 | D3 |
    Then A Fullhouse would be detected
