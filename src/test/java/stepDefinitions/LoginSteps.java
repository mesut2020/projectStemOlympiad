package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @When("As a user, I can navigate to Login page")
    public void asAUserICanNavigateToLoginPage() {
        loginPage.nvigateToLoginPage();

    }

    @Then("User should see the Login page title")
    public void userShouldSeeTheLoginPageTitle() {
        loginPage.checkTittleOfPage(loginPage.welcomeMessage, "welcome!");

    }

    @When("user clicks to Sign up")
    public void userClicksToSignUp() {
        loginPage.clickTo(loginPage.signUpSpr);
    }

    @Then("The registration Pop-up should appear")
    public void theRegistrationPopUpShouldAppear() {
        // loginPage.checkTittleOfPage(loginPage.superVisorPageTitle, "Supervisor Sign up");

    }

    @When("User enters {string} as a firstname")
    public void userEntersAsAFirstname(String firstname1) {
        loginPage.typeName(firstname1);

    }

    @And("User enters {string} as a lastname")
    public void userEntersAsALastname(String lastname1) {
        loginPage.typeSurname(lastname1);
    }

    @And("User enters {string} as a phone Number")
    public void userEntersAsAPhoneNumber(String phoneNumber1) {
        loginPage.typePhone(phoneNumber1);
    }

    @And("User enters {string} as phone number type")
    public void userEntersAsPhoneNumberType(String phoneNoType1) {
        loginPage.selectPhoneType(phoneNoType1);
    }

    @And("User enters {string} as a country name")
    public void userEntersAsACountryName(String country1) {
        loginPage.selectCountry(country1);

    }

    @And("User enters {string} as a city")
    public void userEntersAsACity(String city1) {
        loginPage.typeCity(city1);
    }

    @And("User enters {string} as a school name")
    public void userEntersAsASchoolName(String schoolName1) {
        loginPage.typeSchoolName(schoolName1);
    }

    @And("User enters {string} as a branch")
    public void userEntersAsABranch(String branch1) {
        loginPage.selectBranch(branch1);
    }

    @And("User enters {string} as a email")
    public void userEntersAsAEmail(String email1) {

        loginPage.typeEmail(email1);
    }

    @And("User enters {string} to confirm the email")
    public void userEntersToConfirmTheEmail(String emailConfirm1) {
        loginPage.typeEmailConfirm(emailConfirm1);
    }

    @And("User enters {string} as a password")
    public void userEntersAsAPassword(String password1) {
        loginPage.typePassword(password1);
    }

    @And("User enters {string} to confirm the password")
    public void userEntersToConfirmThePassword(String passwordConfirm1) {
        loginPage.typePasswordConfirm(passwordConfirm1);
    }

    @And("User clicks sign up button")
    public void userClicksSignUpButton() {

        loginPage.clickSubmitButton();
    }

    @Then("User see the error {string}")
    public void userSeeTheError(String message1) {
        loginPage.checkMessage((message1));
    }

    @Then("User should see the error {string}")
    public void userShouldSeeTheError(String message2) throws InterruptedException {
        loginPage.checkMessage2((message2));
    }

    @And("user clicks to Cancel")
    public void userClicksToCancel() {
        loginPage.clickTo(loginPage.cancel);
    }

    @Then("The Login Pop-up should appear")
    public void theLoginPopUpShouldAppear() {
        // loginPage.checkTittleOfPage(loginPage.superVisorPageTitle, "Supervisor Sign up");
    }

    @When("User enters {string} as a username")
    public void userEntersAsAUsername(String username1) {
        loginPage.typeUserName(username1);
    }

    @Then("User clicks sign in button")
    public void userClicksSignInButton() {
        loginPage.clickTo(loginPage.signInSubmit);


    }

    @Then("user clicks to MyAccount and Sign out")
    public void userClicksToMyAccountAndSignOut() {
        loginPage.clickTo(loginPage.myAccount);
        loginPage.clickTo(loginPage.signOut);

    }

    @When("user clicks to Sign in")
    public void userClicksToSignIn() {
        loginPage.clickTo(loginPage.signInSpr);
    }

    @And("User enters {string} sign in page as a password")
    public void userEntersSignInPageAsAPassword(String password2) {

        loginPage.typePasswordSignIn(password2);
    }

    @Then("User should see the succes {string}")
    public void userShouldSeeTheSucces(String message3) throws InterruptedException {
        loginPage.checkMessage3(message3);
    }
}
