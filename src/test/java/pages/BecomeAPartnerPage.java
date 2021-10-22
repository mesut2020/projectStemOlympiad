package pages;

import org.openqa.selenium.By;
import utilities.ParentClass;

import java.util.Map;

public class BecomeAPartnerPage extends ParentClass {
    By BecomeAPartnerLinkButton=By.xpath("//a[@href=\"Become-a-Partner-Form.html\"]");
    By Country=By.xpath("//input[@placeholder='Enter Country']");
    By City=By.xpath("//input[@placeholder='Enter City']");
    By Company=By.xpath("//input[@placeholder='Enter Company / Institute']");
    By Name=By.xpath("//input[@placeholder='Enter Name']");
    By Surname=By.xpath("//input[@placeholder='Enter Surname']");
    By PositionInCompany=By.xpath("//input[@placeholder='Enter Position in Company']");
    By WebPage=By.xpath("//input[@placeholder='Enter Web Page']");
    By EMail=By.xpath("//input[@type='email']");
    By MobilePhoneNr=By.xpath("//input[@placeholder='Enter Mobile Phone Nr']");
    By ReferencesNotes=By.xpath("//textarea[@placeholder='Enter References / Notes']");
    By SubmitButton=By.xpath("//a[@class='u-btn u-btn-submit u-button-style']");



    public  void clickToBecomeAPartnerPage(){
        clickTo(BecomeAPartnerLinkButton);

    }
    public void becomeAPartnerPage(Map<String, String> map){
        String country = map.get("Country");
        String city = map.get("City");
        String company = map.get("Company");
        String name = map.get("Name");
        String surname = map.get("Surname");
        String positionInCompany = map.get("PositionInCompany");
        String webPage = map.get("WebPage");
        String eMail = map.get("EMail");
        String mobilePhoneNr = map.get("MobilePhoneNr");
        String references = map.get("ReferencesNotes");

        sendKeysTo(Country, country);
        sendKeysTo(City, city);
        sendKeysTo(Company, company);
        sendKeysTo(Name, name);
        sendKeysTo(Surname, surname);
        sendKeysTo(PositionInCompany, positionInCompany);
        sendKeysTo(WebPage, webPage);
        sendKeysTo(EMail, eMail);
        sendKeysTo(MobilePhoneNr,mobilePhoneNr);
        sendKeysTo(ReferencesNotes,references);
       // clickTo(SubmitButton);

    }


}
