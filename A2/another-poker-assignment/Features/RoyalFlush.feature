Feature: Royal Flush Check

  Scenario: A Scrambled royal flush
    Given A user has five cards in random order for a royal flush
      | DA | D10 | DQ | DK | DJ |
    Then A royal flush would be detected
