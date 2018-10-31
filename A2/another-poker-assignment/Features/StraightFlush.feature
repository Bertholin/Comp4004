Feature: straight Flush Check

  Scenario: A Scrambled straight flush
    Given A user has five cards in random order for straight
      | D7 | D10 | D9 | D8 | DJ |
    Then A Straight flush would be detected
