package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ContactPage;

public class ContactPageSteps {
    ContactPage contactPage = new ContactPage();
    @When("As a user, I can navigate to contact page")
    public void asAUserICanNavigateToContactPage() {
        contactPage.nvigateToContactPage();
    }

    @Then("User should see the contact page title")
    public void userShouldSeeTheContactPageTitle() {
        Assert.assertTrue(contactPage.getTittleOfContactPage().contains("Contact"));
    }

    @When("User enters {string} as a name")
    public void userEntersAsAName(String name) {
        contactPage.typeName(name);
    }

    @And("User enters {string} as a surname")
    public void userEntersAsASurname(String surname) {
        contactPage.typeSurname(surname);
    }

    @And("User enters {string} as an email")
    public void userEntersEmailAsAnEmail(String email) {
        contactPage.typeEmail(email);
    }

    @And("User enters {string} to confrim email")
    public void userEntersToConfrimEmail(String confirmEmail) {
        contactPage.typeConfirmEmail(confirmEmail);
    }

    @And("User enters {string} as aschool name")
    public void userEntersAsAschoolName(String schoolName) {
        contactPage.typeSchoolname(schoolName);
    }

    @And("User enters {string} as a country")
    public void userEntersAsACountry(String country) {
        contactPage.typeCountry(country);
    }

    @And("User enters {string} as a student number")
    public void userEntersAsAStudentNumber(String studentNumber) {
        contactPage.typeStudentNumber(studentNumber);
    }

    @And("User enters {string} as a message")
    public void userEntersAsAMessage(String message) {
        contactPage.typeMessage(message);
    }

    @And("User clicks submit button")
    public void userClicksSubmitButton() {
        contactPage.clickSubmitButton();
    }

    @Then("User see the success message {string}")
    public void userSeeTheSuccessMessage(String successMessage) {
        Assert.assertTrue(contactPage.isSuccesMessageDisplayed());
    }

    @Then("User see the error message")
    public void userSeeTheErrorMessage() {
        Assert.assertFalse(contactPage.isSuccesMessageDisplayed());
    }


}
