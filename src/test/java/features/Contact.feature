Feature: Contact page functionility

  Background:
    Given As a user, I can navigate to the i-STEM Olympiad WebSite "http://www.stemolympiad.online/"
    When As a user, I can navigate to contact page
    Then User should see the contact page title

  Scenario Outline: User goes to contact page and fill out form with valid credentials
    When User enters "<name>" as a name
    And User enters "<surname>" as a surname
    And User enters email "<email>" as an email
    And User enters "<confirmEmail>" to confrim email
    And User enters "<schoolName>" as aschool name
    And User enters "<country>" as a country
    And User enters "<studentNumber>" as a student number
    And User enters "<message>" as a message
    And User clicks submit button
    Then User see the success message " Thank you! Your message has been sent. "
    Examples:
      | name            | surname            | email         | confirmEmail  | schoolName            | country                | studentNumber | message                      |
      | TestContactName | TestContactSurName | test@test.com | test@test.com | TestContactSchoolName | TestContactCountryName | 123456789     | I am testing contact page... |

  Scenario Outline: : User goes to contact page and fill out form with invalid email
    When User enters "<name>" as a name
    And User enters "<surname>" as a surname
    And User enters email "<email>" as an email
    And User enters "<confirmEmail>" to confrim email
    And User enters "<schoolName>" as aschool name
    And User enters "<country>" as a country
    And User enters "<studentNumber>" as a student number
    And User enters "<message>" as a message
    And User clicks submit button
    Then User see the error message
    Examples:
      | name            | surname            | email        | confirmEmail  | schoolName            | country                | studentNumber | message                      |
      | TestContactName | TestContactSurName | testtest.com | test@test.com | TestContactSchoolName | TestContactCountryName | 123456789     | I am testing contact page... |
      | TestContactName | TestContactSurName | test@testcom | test@test.com | TestContactSchoolName | TestContactCountryName | 123456789     | I am testing contact page... |

  Scenario Outline: : User goes to contact page and fill out form with invalid student number
    When User enters "<name>" as a name
    And User enters "<surname>" as a surname
    And User enters email "<email>" as an email
    And User enters "<confirmEmail>" to confrim email
    And User enters "<schoolName>" as aschool name
    And User enters "<country>" as a country
    And User enters "<studentNumber>" as a student number
    And User enters "<message>" as a message
    And User clicks submit button
    Then User see the error message
    Examples:
      | name            | surname            | email         | confirmEmail  | schoolName            | country                | studentNumber | message                      |
      | TestContactName | TestContactSurName | test@test.com | test@test.com | TestContactSchoolName | TestContactCountryName | AbCd56789     | I am testing contact page... |
      | TestContactName | TestContactSurName | test@test.com | test@test.com | TestContactSchoolName | TestContactCountryName | studentNumber | I am testing contact page... |

  Scenario Outline: User goes to contact page and confirm email with different email
    When User enters "<name>" as a name
    And User enters "<surname>" as a surname
    And User enters email "<email>" as an email
    And User enters "<confirmEmail>" to confrim email
    And User enters "<schoolName>" as aschool name
    And User enters "<country>" as a country
    And User enters "<studentNumber>" as a student number
    And User enters "<message>" as a message
    And User clicks submit button
    Then User see the error message
    Examples:
      | name            | surname            | email         | confirmEmail | schoolName            | country                | studentNumber | message                      |
      | TestContactName | TestContactSurName | test@test.com | pes@pes.com  | TestContactSchoolName | TestContactCountryName | 123456789     | I am testing contact page... |


  Scenario Outline: User goes to contact page and fill out form with missing data
    When User enters "<name>" as a name
    And User enters "<surname>" as a surname
    And User enters email "<email>" as an email
    And User enters "<confirmEmail>" to confrim email
    And User enters "<schoolName>" as aschool name
    And User enters "<country>" as a country
    And User enters "<studentNumber>" as a student number
    And User enters "<message>" as a message
    And User clicks submit button
    Then User see the error message
    Examples:
      | name            | surname            | email         | confirmEmail  | schoolName            | country                | studentNumber | message                      |
      |                 | TestContactSurName | test@test.com | test@test.com | TestContactSchoolName | TestContactCountryName | 123456789     | I am testing contact page... |
      | TestContactName |                    | test@test.com | test@test.com | TestContactSchoolName | TestContactCountryName | 123456789     | I am testing contact page... |
      | TestContactName | TestContactSurName |               | test@test.com | TestContactSchoolName | TestContactCountryName | 123456789     | I am testing contact page... |
      | TestContactName | TestContactSurName | test@test.com |               | TestContactSchoolName | TestContactCountryName | 123456789     | I am testing contact page... |
      | TestContactName | TestContactSurName | test@test.com | test@test.com |                       | TestContactCountryName | 123456789     | I am testing contact page... |
      | TestContactName | TestContactSurName | test@test.com | test@test.com | TestContactSchoolName |                        | 123456789     | I am testing contact page... |
      | TestContactName | TestContactSurName | test@test.com | test@test.com | TestContactSchoolName | TestContactCountryName |               | I am testing contact page... |
      | TestContactName | TestContactSurName | test@test.com | test@test.com | TestContactSchoolName | TestContactCountryName | 123456789     |                              |


#  style="display: none;"
#  style="display: block ;"
