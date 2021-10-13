package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.ParentClass;

public class ContactPage extends ParentClass {

    private By contactPageLink = By.xpath("(//a[text()='CONTACT'])[1]");
    private By nameInput = By.name("name");
    private By surnameInput = By.name("surname");
    private By emailInput = By.name("email");
    private By confirmEmailInput = By.name("emailok");
    private By schoolNameInput = By.name("schoolname");
    private By countryInput = By.name("country");
    private By studentNumberInput = By.name("student-number");
    private By messageInput = By.name("message");
    private By submitButton = By.cssSelector("div.u-align-right.u-form-group.u-form-submit>a");
    private By successMessage = By.cssSelector("div.u-form-send-message.u-form-send-success");

    public void nvigateToContactPage () {
        clickTo(contactPageLink);
    }

    public String getTittleOfContactPage () {
        return driver.getTitle();
    }

    public void fillContactForm(){
        sendKeysTo(nameInput, "TestContactName");
        sendKeysTo(surnameInput, "TestContactSurName");
        sendKeysTo(emailInput, "test@test.com");
        sendKeysTo(confirmEmailInput, "test@test.com");
        sendKeysTo(schoolNameInput, "TestContactSchoolName");
        sendKeysTo(countryInput, "TestContactCountryName");
        sendKeysTo(studentNumberInput, "123456789");
        sendKeysTo(messageInput, "I am testing contact page...");
        clickTo(submitButton);
    }

    public void typeName(String name){
        sendKeysTo(nameInput, name);
    }

    public void typeSurname(String surname){
        sendKeysTo(surnameInput, surname);
    }

    public void typeEmail(String email){
        sendKeysTo(emailInput, email);
    }

    public void typeConfirmEmail(String confirmEmail){
        sendKeysTo(confirmEmailInput, confirmEmail);
    }

    public void typeSchoolname(String schoolName){
        sendKeysTo(schoolNameInput, schoolName);
    }

    public void typeCountry(String country){
        sendKeysTo(countryInput, country);
    }

    public void typeStudentNumber(String studentNumber){
        sendKeysTo(studentNumberInput, studentNumber);
    }

    public void typeMessage(String message){
        sendKeysTo(messageInput, message);
    }

    public void clickSubmitButton(){
        clickTo(submitButton);
    }

    public boolean isSuccesMessageDisplayed(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(successMessage).isDisplayed();
    }

}
