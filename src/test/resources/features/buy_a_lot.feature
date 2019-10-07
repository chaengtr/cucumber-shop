Feature: Buy a lot for products

Background:
    Given ร้านมีสินค้า
#    | name | price |
    | เตารีด | 1000 |
    | ตู้เย็น | 3000 |
    | เตาอบ | 5000 |
    | ทีวี | 2500 |

Scenario: Buy 3 products
    When ฉันซื้อ ตู้เย็น with quantity 2
    And ฉันซื้อ เตารีด with quantity 3
    And ฉันซื้อ เตาอบ with quantity 1
    Then total should be 14000

Scenario Outline: Buy one product
    When ฉันซื้อ <product> with quantity <quantity>
    Then total should be <total>
    Examples:
        | product | quantity | total |
        | ตู้เย็น | 2 | 6000 |
        | เตารีด | 3 | 3000 |
        | เตาอบ | 1 | 5000 |