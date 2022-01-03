Feature: Automate End 2 End test
Description: The purpose of this feature is to test End 2 End integration
 Scenario Outline: Customer place an order by purchaseing an item from search
 
Given User is in Home Page
When he search for "<ProductName>"
And Choose to buy
Then Move to checkout cart and enter personel details on checkout page and place the order 


Examples:
|ProductName|
|Apple MacBook pro 13-inch|