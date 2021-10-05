package pages;

import utilities.Driver;
import utilities.ParentClass;

public class HomePage extends ParentClass {
    public void naviagteToStem(String url){
        driver.get(url);
    }
}
