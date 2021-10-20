package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.ParentClass;

import java.util.ArrayList;

public class LoginPage extends ParentClass {
    public By signInSpr = By.xpath("(//button[@CLASS='btn base-button m-0 btn-warning'])[2]");
    public By signUpSpr = By.xpath("(//button[@class='btn base-button m-0 btn-primary'])[2]");
    private By loginRegistration = By.xpath("//a[@href='https://v2022.stemolympiad.online/']");
    public By welcomeMessage = By.xpath("//div[@class='px-5 col-md-8 col-lg-6 col-xl-5']/h1");
    public By superVisorPageTitle = By.xpath("//h3[@class='modal-title']");
    public By myAccount = By.xpath("(//span[@class='mb-0 text-sm font-weight-bold'])[2]");
    public By signOut = By.xpath("//*[@id='nav-text-collapse']/ul[2]/li/ul/li/a/span");
    public By cancel= By.xpath("//*[@id='__BVID__36___BV_modal_footer_']/div/div/button[1]");
    public By myStudents= By.xpath("//div[@class='d-flex justify-content-between mb-3']/h3");

    private By username = By.xpath("//input[@placeholder='Email']");
    private By password123 = By.xpath("//input[@placeholder='Password']");

    private By firstname = By.xpath("//input[@placeholder='First Name']");
    private By lastname = By.xpath("//input[@placeholder='Last Name']");
    private By phoneNumber = By.xpath("//input[@name='telephone']");
    private By selectPhoneNoType = By.xpath("(//select[@class='custom-select'])[1]");
    private By country = By.xpath("(//select[@class='custom-select'])[2]");
    private By city = By.xpath("//input[@placeholder='City']");
    private By schoolName= By.xpath("//input[@placeholder='School Name']");
    private By branch = By.xpath("(//select[@class='custom-select'])[3]");
    private By email = By.xpath("//input[@placeholder='Email']");
    private By emailComfirm = By.xpath("//input[@placeholder='Email Confirm']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By passwordConfirm = By.xpath("//input[@placeholder='Password Confirm']");
    private By errorMessage = By.xpath("//span[@class='text-danger small flex-fill']");
    private By errorMessage2 = By.xpath("//span[@class='text-danger flex-fill small']");

    private By signUpSubmit = By.xpath("//button[@class='btn base-button btn-primary']");
    public By signInSubmit = By.xpath("//button[@CLASS='btn base-button btn-primary']");

    public void nvigateToLoginPage () {
        clickTo(loginRegistration);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));



    }

    public String getTittleOfContactPage () {
        return driver.getTitle();
    }

    public void checkTittleOfPage (By by, String text) {
        Assert.assertEquals(driver.findElement(by).getText().toLowerCase(), text);
    }

    public void fillContactForm(){
        sendKeysTo(firstname, "TestName");
        sendKeysTo(lastname, "TestSurName");
        sendKeysTo(phoneNumber, "0123456");
        selectByVisibleValue(selectPhoneNoType, "Whatsapp");
        selectByVisibleValue(country, "Germany");
        sendKeysTo(city, "TestCity");
        sendKeysTo(schoolName, "TestSchool");
        selectByVisibleValue(branch, "Science");
        sendKeysTo(email, "test@test.com");
        sendKeysTo(emailComfirm, "test@test.com");
        sendKeysTo(password, "ea4s5");
        sendKeysTo(passwordConfirm, "ea4s5");
        sendKeysTo(passwordConfirm, "ea4s5");
        clickTo(signUpSubmit);
        checkTheMessage(errorMessage, "First Name is required.");
        sendKeysTo(username, ".");
        sendKeysTo(password123, ".");
        checkTheMessage(errorMessage2,"Invalid credentials");
        checkTheMessage(myStudents,"My Students");
    }

    public void typeName(String firstname1)
    {
        sendKeysTo(firstname, firstname1);
    }
    public void typeUserName(String username1)
    {
        sendKeysTo(username, username1);
    }

    public void typeSurname(String lastname1){
        sendKeysTo(lastname, lastname1);
    }

    public void typePasswordSignIn(String password2){
        sendKeysTo(password123, password2);
    }

    public void typePhone(String phoneNumber1){
        sendKeysTo(phoneNumber, phoneNumber1);
    }

    public void selectPhoneType(String phoneNoType1){
        selectByVisibleValue(selectPhoneNoType, phoneNoType1);
    }

    public void selectCountry(String country1){
        selectByVisibleValue(country, country1);
    }

    public void typeCity(String city1){
        sendKeysTo(city, city1);
    }

    public void typeSchoolName(String schoolName1){
        sendKeysTo(schoolName, schoolName1);
    }

    public void selectBranch(String branch1){
        selectByVisibleValue(branch, branch1);
    }
    public void typeEmail(String email1){
        sendKeysTo(email, email1);
    }
    public void typeEmailConfirm(String emailConfirm1){
        sendKeysTo(emailComfirm, emailConfirm1);
    }
    public void typePassword(String password1){
        sendKeysTo(password, password1);
    }

    public void typePasswordConfirm(String passwordConfirm1){
        sendKeysTo(passwordConfirm, passwordConfirm1);
    }

    public void checkMessage(String message1){
       checkTheMessage(errorMessage, message1);
    }
    public void checkMessage2(String message2) throws InterruptedException {

            Thread.sleep(4000);

        checkTheMessage(errorMessage2, message2);
    }

    public void checkMessage3(String message3) throws InterruptedException {

        Thread.sleep(4000);

        checkTheMessage(myStudents, message3);
    }
    public void clickSubmitButton(){
        clickTo(signUpSubmit);
    }




    /*public boolean isSuccesMessageDisplayed(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(successMessage).isDisplayed();
    }*/

}
