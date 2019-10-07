Feature: Check quantity

Background:
    Given we have these products
#    | name      | price | quantity  |
    | Bread     | 20.5  | 20        |
    | Jam       | 80    | 10        |
    | Butter    | 120   | 5         |
    | Milk      | 45    | 8         |

Scenario: Buy product less than quantity
    When I buy Bread with quantity 2 less than quantity
    Then remaining quantity of Bread is 18

Scenario: Buy product more than quantity
     When I buy Milk with quantity 10 more than quantity
     Then remaining quantity of Milk is 8