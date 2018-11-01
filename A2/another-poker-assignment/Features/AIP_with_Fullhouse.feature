Feature: AIP fullHouse vs other hands

  Scenario: The HTB has a flush vs fullHouse
    Given The AIP has a fullHouse vs flush "C6 C7 C2 C8 C10 C8 S9 S8 H9 D9"
    And the AIP holds the fullHouse
    Then the AIP (fullHouse) beats the HTB

  Scenario: The HTB has a straight vs fullHouse
    Given The AIP has a fullHouse vs straight "C6 D7 S9 H8 S10 C8 S9 S8 H9 D9"
    And the AIP holds the fullHouse
    Then the AIP (fullHouse) beats the HTB

  Scenario: The HTB has three of a kind vs fullHouse
    Given The AIP has a fullHouse vs threeOfAKind "S6 H6 H9 D8 C6 C8 S9 S8 H9 D9"
    And the AIP holds the fullHouse
    Then the AIP (fullHouse) beats the HTB

  Scenario: The HTB has a Tow Pair vs fullHouse
    Given The AIP has a fullHouse vs twoPair "H2 D2 C9 S9 SA C8 S9 S8 H9 D9"
    And the AIP holds the fullHouse
    Then the AIP (fullHouse) beats the HTB

  Scenario: The HTB has a Pair vs fullHouse
    Given The AIP has a fullHouse vs pair "C5 S7 H9 D8 S5 C8 S9 S8 H9 D9"
    And the AIP holds the fullHouse
    Then the AIP (fullHouse) beats the HTB

  Scenario: The HTB has a high Card vs fullHouse 
    Given The AIP has a fullHouse vs highCard "CQ H10 D4 C5 S9 C8 S9 S8 H9 D9"
    And the AIP holds the fullHouse
    Then the AIP (fullHouse) beats the HTB
