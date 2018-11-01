Feature: AIP flush vs other hands

  Scenario: The HTB has a straight vs flush
    Given The AIP has a flush vs straight "C6 D7 S9 H8 S10 C6 C7 C2 C8 C10"
    And the AIP holds the flush
    Then the AIP (flush) beats the HTB

  Scenario: The HTB has three of a kind vs flush
    Given The AIP has a flush vs threeOfAKind "S6 H6 H9 D8 C6 C6 C7 C2 C8 C10"
    And the AIP holds the flush
    Then the AIP (flush) beats the HTB

  Scenario: The HTB has a Tow Pair vs flush
    Given The AIP has a flush vs twoPair "H2 D2 C9 S9 SA C6 C7 C2 C8 C10"
    And the AIP holds the flush
    Then the AIP (flush) beats the HTB

  Scenario: The HTB has a Pair vs flush
    Given The AIP has a flush vs pair "C5 S7 H9 D8 S5 C6 C7 C2 C8 C10"
    And the AIP holds the flush
    Then the AIP (flush) beats the HTB

  Scenario: The HTB has a high Card vs flush 
    Given The AIP has a flush vs highCard "CQ H10 D4 C5 S9 C6 C7 C2 C8 C10"
    And the AIP holds the flush
    Then the AIP (flush) beats the HTB
