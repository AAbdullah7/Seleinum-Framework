Feature: User Registerartion
I want to check that the user can register in our e-commerce website


Scenario Outline: User Registeration

Given The user in the home page
When I click on register link
And I entered "<FirstName>" , "<LastName>" , "<Email>" , "<Password>"
Then The registeration page displayed successfully

Examples:

| FirstName | LastName | Email | Password |
| Abdelrahman | Abdullah | Testy29@test.com | 82645123 |
| Ahmed | Abdullah | Testt222@test.com | 82645123 |
