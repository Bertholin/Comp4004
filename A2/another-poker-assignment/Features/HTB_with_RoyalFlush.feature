Feature: Royal Flush Check

  Scenario: The HTB has a Royal Flush vs a Straight Flush
    Given The HTB has a Royal Flush "DA D10 DQ DK DJ D6 D7 D9 D8 D5"
    Then the HTB beats the AIP

  Scenario: The HTB has a Royal Flush vs four of a Kind
    Given The HTB has a Royal Flush "DA D10 DQ DK DJ H6 D6 C6 S6 S10"
    Then the HTB beats the AIP

  Scenario: The HTB has a Royal Flush vs full house
    Given The HTB has a Royal Flush "DA D10 DQ DK DJ C8 S9 S8 H9 D9"
    Then the HTB beats the AIP

  Scenario: The HTB has a Royal Flush vs a flush
    Given The HTB has a Royal Flush "DA D10 DQ DK DJ C6 C7 C2 C8 C10"
    Then the HTB beats the AIP

  Scenario: The HTB has a Royal Flush vs a straight
    Given The HTB has a Royal Flush "DA D10 DQ DK DJ C6 D7 S9 H8 S10"
    Then the HTB beats the AIP

  Scenario: The HTB has a Royal Flush vs a three of a kind
    Given The HTB has a Royal Flush "DA D10 DQ DK DJ S6 H6 H9 D8 C6"
    Then the HTB beats the AIP

  Scenario: The HTB has a Royal Flush vs two pair
    Given The HTB has a Royal Flush "DA D10 DQ DK DJ H2 D2 C9 S9 SA"
    Then the HTB beats the AIP

  Scenario: The HTB has a Royal Flush vs a pair
    Given The HTB has a Royal Flush "DA D10 DQ DK DJ C5 S7 H9 D8 S5"
    Then the HTB beats the AIP

  Scenario: The HTB has a Royal Flush vs high Card
    Given The HTB has a Royal Flush "DA D10 DQ DK DJ CQ H10 D4 C5 S9"
    Then the HTB beats the AIP
