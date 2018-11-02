Feature: AIP Strategy for exchanges cards
    
    Scenario: The AIP Has one card away from royal flush and exchanges it and gets it.
    Given The AIP has a Almost Royal Flush and exchanges a card win "H2 S5 S3 C9 S10 DA D10 DQ DK H8"
    Then the AIP changes a card and win
    
    Scenario: The AIP Has one card away from royal flush and exchanges it and doesnt get it.
    Given The AIP has a Almost Royal Flush and exchanges a card lose "H9 S5 S3 C9 S10 DA D10 DQ DK H8"
    Then the AIP changes a card and loses
    
    Scenario: The AIP Has one card away from Straight flush and exchanges it and gets it.
    Given The AIP has a Almost Straight Flush and exchanges a card win "D10 DQ D5 H8 C5 S2 S5 S3 S4 H10"
    Then the AIP changes a card and win
    
    Scenario: The AIP Has one card away from Straight flush and exchanges it and doesnt get it.
    Given The AIP has a Almost Straight Flush and exchanges a card lose "D10 DQ D5 H8 C5 S2 S5 S3 S4 H10"
    Then the AIP changes a card and loses
    
    Scenario: The AIP Has three of a kind and exchanges it and gets it.
    Given The AIP has three of a kind and exchanges a card win "D10 DQ D5 H8 C5 S2 C2 D2 S4 H10"
    Then the AIP changes a card and win
    
    Scenario: The AIP Has three of a kind and exchanges it and doesnt get it.
    Given The AIP has three of a kind and exchanges a card lose "S7 C7 D7 H7 C5 S2 C2 D2 S4 H10"
    Then the AIP changes a card and loses
    
    Scenario: The AIP Has two pair and exchanges it and gets it.
    Given The AIP has two pair and exchanges a card win "D10 DQ D5 H8 C5 S2 C2 D4 S4 H10"
    Then the AIP changes a card and win
    
    Scenario: The AIP Has two pair and exchanges it and doesnt get it.
    Given The AIP has two pair and exchanges a card lose "S7 C7 D7 H7 C5 S2 C2 D4 S4 H10"
    Then the AIP changes a card and loses
    
    Scenario: The AIP Has flush and exchanges it and gets it.
    Given The AIP has flush and exchanges a card win "D10 DQ D5 H8 C5 CA C2 C4 C3 H10"
    Then the AIP changes a card and win
    
    Scenario: The AIP Has flush and exchanges it and doesnt get it.
    Given The AIP has flush and exchanges a card lose "S7 C7 D7 H7 C5 CA C2 C4 C3 H10"
    Then the AIP changes a card and loses
    
    Scenario: The AIP Has straight and exchanges it and gets it.
    Given The AIP has straight and exchanges a card win "D10 DQ D5 H8 C5 DA S2 C4 H3 H10"
    Then the AIP changes a card and win
    
    Scenario: The AIP Has straight and exchanges it and doesnt get it.
    Given The AIP has straight and exchanges a card lose "S7 C7 D7 H7 C5 CA C2 C4 C3 H10"
    Then the AIP changes a card and loses
    
    Scenario: The AIP Has three of the same suit and exchanges the other two.
    Given The AIP has three of the same suit and exchanges two cards "S7 C7 D7 H7 C5 C8 C2 C7 D3 H10"
    Then we dont care about the outcome
    
    Scenario: The AIP Has three in a sequence and exchanges the other two.
    Given The AIP has three in a sequence and exchanges two cards "S7 C7 D7 H7 C5 H9 C2 C4 C3 H10"
    Then we dont care about the outcome
    
    Scenario: The AIP Has one pair and exchanges the other two.
    Given The AIP has one pair and exchanges three cards "S7 C7 D7 H7 C5 H9 C9 S6 C2 HQ"
    Then we dont care about the outcome
    
    Scenario: The AIP No pair and Holds the two highest and exchanges the others.
    Given The AIP has No pair and Holds the two highest "S7 C7 D7 H7 C5 H9 C10 S6 C2 HQ"
    Then we dont care about the outcome