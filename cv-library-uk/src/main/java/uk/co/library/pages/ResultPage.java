package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.utility.Utility;

public class ResultPage extends Utility {
    public ResultPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='search-header__title']")
    WebElement resultText;

    public String verifyTheResults()
    {
        Reporter.log("getting The Results from "+resultText.toString()+"<br>");
        return getTextFromElement(resultText);
    }
}
