Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given a product Bread with price 20.50 exists
    And a product Jam with price 80.00 exists
    And a product Butter with price 120.00 exists
    And a product Milk with price 45.00 exists

Scenario: Buy one product
    When ฉันซื้อ Bread with quantity 2
    Then total should be 41.00

Scenario: Buy multiple products
    When ฉันซื้อ Bread with quantity 2
    And ฉันซื้อ Jam with quantity 1
    Then total should be 121.00


