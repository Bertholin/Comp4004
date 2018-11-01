Feature: AIP Royal Flush vs other hands

  Scenario: The HTB has a Straight Flush vs Royal Flush
    Given The AIP has a Royal Flush vs straightFlush "D6 D7 D9 D8 D5 DA D10 DQ DK DJ"
    And the AIP holds the Royal Flush
    Then the AIP (Royal Flush) beats the HTB

  Scenario: The HTB has a four of a Kind vs Royal Flush 
    Given The AIP has a Royal Flush vs fourOfAKind "H6 D6 C6 S6 S10 DA D10 DQ DK DJ"
    And the AIP holds the Royal Flush
    Then the AIP (Royal Flush) beats the HTB

  Scenario: The HTB has a full house vs Royal Flush 
    Given The AIP has a Royal Flush vs fullHouse "C8 S9 S8 H9 D9 DA D10 DQ DK DJ"
    And the AIP holds the Royal Flush
    Then the AIP (Royal Flush) beats the HTB

  Scenario: The HTB has a flush vs Royal Flush
    Given The AIP has a Royal Flush vs flush "C6 C7 C2 C8 C10 DA D10 DQ DK DJ"
    And the AIP holds the Royal Flush
    Then the AIP (Royal Flush) beats the HTB

  Scenario: The HTB has a straight vs Royal Flush
    Given The AIP has a Royal Flush vs straight "C6 D7 S9 H8 S10 DA D10 DQ DK DJ"
    And the AIP holds the Royal Flush
    Then the AIP (Royal Flush) beats the HTB

  Scenario: The HTB has three of a kind vs Royal Flush
    Given The AIP has a Royal Flush vs threeOfAKind "S6 H6 H9 D8 C6 DA D10 DQ DK DJ"
    And the AIP holds the Royal Flush
    Then the AIP (Royal Flush) beats the HTB

  Scenario: The HTB has a Tow Pair vs Royal Flush
    Given The AIP has a Royal Flush vs twoPair "H2 D2 C9 S9 SA DA D10 DQ DK DJ"
    And the AIP holds the Royal Flush
    Then the AIP (Royal Flush) beats the HTB

  Scenario: The HTB has a Pair vs Royal Flush
    Given The AIP has a Royal Flush vs pair "C5 S7 H9 D8 S5 DA D10 DQ DK DJ"
    And the AIP holds the Royal Flush
    Then the AIP (Royal Flush) beats the HTB

  Scenario: The HTB has a high Card vs Royal Flush 
    Given The AIP has a Royal Flush vs highCard "CQ H10 D4 C5 S9 DA D10 DQ DK DJ"
    And the AIP holds the Royal Flush
    Then the AIP (Royal Flush) beats the HTB
