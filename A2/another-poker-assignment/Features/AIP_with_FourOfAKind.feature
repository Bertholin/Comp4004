Feature: AIP four of a Kind vs other hands

  Scenario: The HTB has a full house vs four of a Kind 
    Given The AIP has a four of a Kind vs fullHouse "C8 S9 S8 H9 D9 H6 D6 C6 S6 S10"
    And the AIP holds the four of a Kind
    Then the AIP (four of a Kind) beats the HTB

  Scenario: The HTB has a flush vs four of a Kind
    Given The AIP has a four of a Kind vs flush "C6 C7 C2 C8 C10 H6 D6 C6 S6 S10"
    And the AIP holds the four of a Kind
    Then the AIP (four of a Kind) beats the HTB

  Scenario: The HTB has a straight vs four of a Kind
    Given The AIP has a four of a Kind vs straight "C6 D7 S9 H8 S10 H6 D6 C6 S6 S10"
    And the AIP holds the four of a Kind
    Then the AIP (four of a Kind) beats the HTB

  Scenario: The HTB has three of a kind vs four of a Kind
    Given The AIP has a four of a Kind vs threeOfAKind "S6 H6 H9 D8 C6 H6 D6 C6 S6 S10"
    And the AIP holds the four of a Kind
    Then the AIP (four of a Kind) beats the HTB

  Scenario: The HTB has a Tow Pair vs four of a Kind
    Given The AIP has a four of a Kind vs twoPair "H2 D2 C9 S9 SA H6 D6 C6 S6 S10"
    And the AIP holds the four of a Kind
    Then the AIP (four of a Kind) beats the HTB

  Scenario: The HTB has a Pair vs four of a Kind
    Given The AIP has a four of a Kind vs pair "C5 S7 H9 D8 S5 H6 D6 C6 S6 S10"
    And the AIP holds the four of a Kind
    Then the AIP (four of a Kind) beats the HTB

  Scenario: The HTB has a high Card vs four of a Kind 
    Given The AIP has a four of a Kind vs highCard "CQ H10 D4 C5 S9 H6 D6 C6 S6 S10"
    And the AIP holds the four of a Kind
    Then the AIP (four of a Kind) beats the HTB
