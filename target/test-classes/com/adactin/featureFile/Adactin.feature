Feature: Hotel Booking Functionality


Scenario Outline: user want to login the Application
Given user want the launch the adatin application
When user enter "<Username>" the valid username
And user enter "<Password>" the valid password
Then user verify valid username and password
  
  Examples:
  |Username|Password|
  |AAA|111|
  |BBB|222|
  |robin999|leo1234|
  

@login
Scenario: user want to login the Application
Given user want the launch the adatin application
When user enter "maran123" the valid username
And user enter "password" the valid password
Then user verify valid username and password

@login
Scenario: user want to search hotel
When user select "Melbourne" the preferred location
And user select "Hotel Sunshine" the preferred hotel
And user select "3" the room type
And user select "1" the number of rooms
And user enter check in date
And user enter select check out date 
And user want to select number of adult per room
And user want to select number of children per room
Then user verify the details


Scenario: user want to confirm the hotel
When user check the check box
Then user verify the confirm hotel


Scenario: user want to book the selected hotel
When user enter the firstname
And  user enter the lastname
And user enter the address
And user enter the card number
And user select the card type
And user select the expiry month
And user select the expiry year
And user enter the CVV number
Then user verify the card details


Scenario: user want to logout the application
When user enter the logout button

