@ebay_task
Feature: ebay_Task

   Scenario Outline: login_with_credentials

    Given user clicks on sign in button
    And user sends username "<username>" and click on continue button
    And user sends password "<password>"
    Then user clicks on the Sign in button

    Examples: credentials
      |username                  |password         |
      |alexxela202107@gmail.com  |Alexxela2023***  |

    Scenario Outline: Add_products_to_cart_1

      Given user writes the "<product name>" to the search box and click search button
      When user clicks on the "<desired item>"
      And user clicks on Add to cart button
      Then verify that selected  product is in the cart

      Examples: product_info
        |product name  |desired item|
        |Messi Jersey #10 Argentina Soccer Jersey 22/23 World Cup  |Messi Jersey #10 Argentina Soccer Jersey 22/23 World Cup - Mens Large - NWT|

  Scenario Outline: Add_products_to_cart_2

    Given user writes the "<product name>" to the search box and click search button
    When user clicks on the second "<desired item>"
    When user selects the size of the Jersey
    And user clicks on Add to cart button
    Then verify that selected  product is in the cart after second product

    Examples: product_info
      |product name  |desired item|
      |New Cristiano Ronaldo Al Nassr FC Soccer Uniform Jersey |New Cristiano Ronaldo Al Nassr FC Soccer Uniform Jersey and Short Kids|


  Scenario Outline: Add_products_to_cart_3

    Given user writes the "<product name>" to the search box and click search button
    When user clicks on the third "<desired item>"
    And user clicks on Add to cart button
    Then verify that selected  product is in the cart after third product

    Examples: product_info
      |product name  |desired item|
      |arda turan jersey|NIKE Atlético Madrid 2014/15 Home Soccer Football Jersey SIZE: XS ARDA #10|

    Scenario: Delete_1_product_from_the_cart

      Given user clicks on the cart
      When user clicks on the remove icon of the first product
      Then user verify that number of total products decreased

      Scenario Outline: Like_product_1

        Given user writes the "<product name>" to the search box and click search button
        When user clicks on like button of desired product

        Examples: product_info
          |product name  |
          |ilhan mansiz jersey |

   Scenario Outline: Like_product_2

    Given user writes the "<product name>" to the search box and click search button
    When user clicks on like button of desired second product

    Examples: product_info
      |product name  |
      |Huawei MatePad 10.4 Inch Wi-Fi Model RAM3GB / ROM32GB Midnight Gray|

  Scenario Outline: Like_product_3

    Given user writes the "<product name>" to the search box and click search button
    When user clicks on desired third product
    When user clicks on Add to watchlist button
    And user clicks on Watchlist on the product page
    Then user verify that number of liked items is correct after third like

    Examples: product_info
      |product name  |
      |ARZUM Okka OK0012 K Rich Spin M Turkish Coffee Makers Machine 5 Cup 220 Volt|

    Scenario: After_Test_Delete_Items_In_Cart

      When user clicks on the cart
      When user clicks on the remove icon of the first product
      When user clicks on the remove icon of the first product
      Then Then user verify that all items are deleted successfully


