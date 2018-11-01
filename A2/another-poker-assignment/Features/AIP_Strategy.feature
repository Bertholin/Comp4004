Feature: AIP with lower than a Straight exchanges cars

  Scenario: The AIP Has one card away from royal flush and exchanges it.
    Given The AIP has a Almost Royal Flush and exchanges a card
     | DA | D10 | DQ | DK | H2 |
    Then the AIP changes a card
    
      Scenario: The AIP Has one card away from royal flush and exchanges it.
    Given The AIP has a Almost Royal Flush and exchanges a card game "S2 S5 S3 S9 S10 DA D10 DQ DK H8"
    Then the AIP changes a card