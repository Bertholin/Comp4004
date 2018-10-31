Feature: Three of a kind Check

  Scenario: A scrambled three of a kind
    Given A user has five cards scrambled which contains three of the same card
      | H7 | SJ | C7 | D7 | D3 |
    Then A three of a kind would be detected
