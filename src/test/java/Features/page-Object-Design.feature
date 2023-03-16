Feature: Login
 Scenario Outline: Login Guru99
    Given Launch the browser and open the URL:"http://demo.guru99.com/V4/"
    When Check the title at the login page
    Then Enter the username as "<userName>" and password as "<passWord>"
    And click the login button
    When Check the manage id at the home page

   Examples:
      | userName | passWord |
      |mngr484060|jUgudYh   |
      |admin111  |12345     |