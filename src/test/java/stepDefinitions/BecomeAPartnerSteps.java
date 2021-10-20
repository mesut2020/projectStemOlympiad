package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BecomeAPartnerPage;

import java.util.Map;


public class BecomeAPartnerSteps {

    BecomeAPartnerPage becomeAPartnerPage=new BecomeAPartnerPage();
    @When("As a user, I can able to click to Become a Partner button link in the home page")
    public void as_a_user_i_can_able_to_click_to_become_a_partner_button_link_in_the_home_page() {
        becomeAPartnerPage.clickToBecomeAPartnerPage();

    }
    @Then("As a user, I can able to fill to application form in the Become a Partner page")
    public void as_a_user_i_can_able_to_fill_to_application_form_in_the_become_a_partner_page(DataTable dataTable) {
        Map<String,String> map=dataTable.asMap(String.class,String.class);
        becomeAPartnerPage.becomeAPartnerPage(map);

    }


}
