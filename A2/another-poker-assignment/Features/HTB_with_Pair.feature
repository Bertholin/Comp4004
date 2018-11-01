Feature: pair vs other hands

  Scenario: The HTB has a pair vs high Card
    Given The HTB has a pair vs highCard "C5 S7 H9 D8 S5 CQ H10 D4 C5 S9"
    Then the HTB (pair) beats the AIP