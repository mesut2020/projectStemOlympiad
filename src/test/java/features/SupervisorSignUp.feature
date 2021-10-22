Feature: Supervisor Sign up

  Background:
    Given As a user, I can navigate to the i-STEM Olympiad WebSite "http://www.stemolympiad.online/"
    When As a user, I can navigate to Login page
    Then User should see the Login page title


  Scenario Outline: User fill out sign up form with valid and invalid credentials
    When user clicks to Sign up
    Then The registration Pop-up should appear
    When User enters "<firstname1>" as a firstname
    And User enters "<lastname1>" as a lastname
    And User enters "<phoneNumber1>" as a phone Number
    And User enters "<phoneNoType1>" as phone number type
    And User enters "<country1>" as a country name
    And User enters "<city1>" as a city
    And User enters "<schoolName1>" as a school name
    And User enters "<branch1>" as a branch
    And User enters "<email1>" as a email
    And User enters "<emailConfirm1>" to confirm the email
    And User enters "<password1>" as a password
    And User enters "<passwordConfirm1>" to confirm the password
    And User clicks sign up button
    Then User see the error "<message1>"
#And user clicks to Cancel
#Then User should see the Login page title

    Examples:
      | firstname1 | lastname1   | phoneNumber1   | phoneNoType1 | country1   | city1    | schoolName1 | branch1          | email1        | emailConfirm1 | password1 | passwordConfirm1 | message1                                                                               |
      | TestName   | TestSurName | 0123456        | Whatsapp     | Germany    | TestCity | testSchool  | Computer Science | test@test.com | test@test.com | ea4s5     | ea4s5            | Invalid phone format                                                                   |
      |            | TestSurName | +4917681234566 | Whatsapp     | Angola     | TestCity | testSchool  | Mathematics      | test@test.com | test@test.com | ea4s5     | ea4s5            | First Name is required.                                                                |
      | TestName   |             | +4917681234566 | Whatsapp     | Cuba       | TestCity | testSchool  | Science          | test@test.com | test@test.com | ea4s5     | ea4s5            | Last Name is required.                                                                 |
      | TestName   | TestSurName | +4917681234566 | Viber        | Bahamas    |          | testSchool  | Chemistry        | test@test.com | test@test.com | ea4s5     | ea4s5            | City is required.                                                                      |
      | TestName   | TestSurName | +4917681234566 | Viber        | Luxembourg | TestCity |             | Technology       | test@test.com | test@test.com | ea4s5     | ea4s5            | School Name is required.                                                               |
      | TestName   | TestSurName | +4917681234566 | Viber        | Poland     | TestCity | testSchool  | Biology          |               | test@test.com | ea4s5     | ea4s5            | Invalid email                                                                          |
      | TestName   | TestSurName | +4917681234566 | Viber        | Pakistan   | TestCity | testSchool  | Science          | test@test.com |               | ea4s5     | ea4s5            | Confirmation mail should match mail                                                    |
      | TestName   | TestSurName | +4917681234566 | Telegram     | Norway     | TestCity | testSchool  | Mathematics      |               |               | ea4s5     | ea4s5            | Invalid email                                                                          |
      | TestName   | TestSurName | +4917681234566 | Telegram     | Turkey     | TestCity | testSchool  | Science          | 1             | 1             | ea4s5     | ea4s5            | Invalid email format                                                                   |
      | TestName   | TestSurName | +4917681234566 | Telegram     | Germany    | TestCity | testSchool  | Biology          | test@test.com | test@test.com |           |                  | Invalid password                                                                       |
      | TestName   | TestSurName | +4917681234566 | Telegram     | Latvia     | TestCity | testSchool  | Mathematics      | test@test.com | test@test.com | ea4s5     | ea4s52           | Invalid password                                                                       |
      | TestName   | TestSurName | +4917681234566 | Telegram     | Germany    | TestCity | testSchool  | Technology       | test@test.com | test@test.com | ea4s5     | ea4s5            | A supervisor with the same email exists. Check your e-mail address or write a new one. |
      | TestName   | TestSurName |                | Telegram     | Germany    | TestCity | testSchool  | Technology       | test@test.com | test@test.com | ea4s5     | ea4s5            | Phone is required.                                                                     |


  Scenario Outline: User fill out sign in form with valid and invalid credentials
    When user clicks to Sign in
    Then The Login Pop-up should appear
    When User enters "<username1>" as a username
    And User enters "<password2>" sign in page as a password
    Then User clicks sign in button
    Then User should see the error "<message2>"
   # Then user clicks to Cancel

    Examples:
      | username1     | password2 | message2            |
      | test@test.com | password  | Invalid credentials |
      | .             | .         | Invalid credentials |
      |               |           | Invalid credentials |
      | test@test.com |           | Invalid credentials |



  Scenario Outline: User fill out sign in form with valid credentials
    When user clicks to Sign in
    Then The Login Pop-up should appear
    When User enters "<username1>" as a username
    And User enters "<password2>" sign in page as a password
    Then User clicks sign in button
    Then User should see the succes "<message3>"
    Then user clicks to MyAccount and Sign out

    Examples:
      | username1     | password2 |message3            |
      | test@test.com | ea4s5     | My Students        |

#  style="display: none;"
#  style="display: block ;"
