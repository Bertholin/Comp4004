Feature: two pair vs other hands

  Scenario: The HTB has a two pair vs a pair
    Given The HTB has a two pair vs pair "H2 D2 C9 S9 SA C5 S7 H9 D8 S5"
    Then the HTB (two pair) beats the AIP

  Scenario: The HTB has a two pair vs high Card
    Given The HTB has a two pair vs highCard "H2 D2 C9 S9 SA CQ H10 D4 C5 S9"
    Then the HTB (two pair) beats the AIP