package stepDefinitions;

import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.HomePage;

public class HomePageSteps {
    @Given("As a user, I can navigate to the i-STEM Olympiad WebSite {string}")
    public void as_a_user_i_can_navigate_to(String url) {
        new HomePage().naviagteToStem(url);
    }
}
