Feature: Four of a kind Check

  Scenario: A scrambled four of a kind
    Given A user has five cards scrambled which contains four of the same card
      | HJ | SJ | CJ | DJ | D3 |
    Then A four of a kind would be detected
