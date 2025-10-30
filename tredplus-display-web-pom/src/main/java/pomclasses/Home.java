package pomclasses;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.pombaseclass;

public class Home extends pombaseclass{
	WebDriver driver;
private WebElement gethomebutton() {
	String locator = prop.getProperty("homebutton");
	return driver.findElement(By.xpath(locator));
}

private WebElement getTitleText() {
	String locator = prop.getProperty("homepageTitleText");
	return driver.findElement(By.xpath(locator));
	
}



public Home(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this); // Initializes the WebElements
}



public void ClickHomeButton() {
	gethomebutton().click();
}
public String getHomePageTitleText() {
    return getTitleText().getText();
}

// ✅ Validation (Optional)
public boolean isTitleTextDisplayed() {
    return getTitleText().isDisplayed();
}



}
