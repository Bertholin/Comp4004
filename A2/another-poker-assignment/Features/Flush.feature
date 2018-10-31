Feature: Flush Check

  Scenario: A Scrambled flush
    Given A user has five cards with the same suit
      | HJ | H2 | H6 | HA | H9 |
    Then A flush would be detected
