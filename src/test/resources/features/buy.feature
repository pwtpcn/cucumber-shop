Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given the store is ready to service customers
    And a product "Bread" with price 20.50 and stock of 5 exists
    And a product "Jam" with price 80.00 and stock of 10 exists
    And a product "Coke" with price 15.00 and stock of 20 exists

#Scenario: Buy one product
#    When I buy "Bread" with quantity 2
#    Then total should be 41.00
#
#Scenario: Buy multiple products
#    When I buy "Bread" with quantity 2
#    And I buy "Jam" with quantity 1
#    And I buy "Coke" with quantity 6
#    Then total should be 211.00

Scenario: Check Stock
    Given the product "Coke" is available
    When I check the stock for "Coke"
    Then the stock for "Coke" should be 20