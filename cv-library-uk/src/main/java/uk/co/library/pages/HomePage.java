package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "keywords")
    WebElement jobTitleField;
    @FindBy (id = "location")
    WebElement locationField;
    @FindBy (id = "distance")
    WebElement distanceDropDown;
    @FindBy (id = "toggle-hp-search")
    WebElement moreSearchOptions;
    @FindBy (id = "salarymin")
    WebElement salaryMin;
    @FindBy (id = "salarymax")
    WebElement salaryMax;
    @FindBy (xpath= "//select[@id='salarytype']")
    WebElement salaryTypeDropDownMenu;
    @FindBy (xpath = "//select[@id='tempperm']")
    WebElement jobTypeDropDown;
    @FindBy (id = "hp-search-btn")
    WebElement findJobsButton;
    @FindBy(xpath = "//*[contains(text(),'Accept')]")
    WebElement acceptCookis;

    public void setAcceptCookis(){
        Reporter.log("Clicking on AcceptCookis"+ acceptCookis.toString()+ "<br>");
        clickOnElement(acceptCookis);
    }


    public void enterJobTitle(String jobTitle) {
        Reporter.log("Enter JobTitle"+jobTitle+ " to email field "+jobTitleField.toString() + "<br>");
        sendTextToElement(jobTitleField, jobTitle);
    }

   public void enterLocation(String location){
       Reporter.log("Enter Location"+location+ " to email field "+locationField.toString() + "<br>");
       sendTextToElement(locationField, location);
    }
    public void selectDistance(String dist) throws InterruptedException {
        Reporter.log("Selecting Distance"+dist+" from dropdown "+distanceDropDown.toString() + "<br>");
        Thread.sleep(1000);
        selectByValueFromDropDown(distanceDropDown, dist);
    }
    public void clickOnMoreSearchOptionLink() {

        Reporter.log("Clicking on MoreSearchOption"+ moreSearchOptions.toString()+ "<br>");
        clickOnElement(moreSearchOptions);
    }
    public void enterMinSalary(String minSalary) {

        Reporter.log("Enter MinSalary"+minSalary+ " to email field "+salaryMin.toString() + "<br>");
        sendTextToElement(salaryMin, minSalary);
    }
    public void enterMaxSalary(String maxSalary) {
        Reporter.log("Enter MaxSalary"+maxSalary+ " to email field "+salaryMax.toString() + "<br>");
        sendTextToElement(salaryMax, maxSalary);
    }
    public void selectSalaryType(String salaryType) {
        Reporter.log("Selecting SalaryType"+salaryType+" from dropdown "+salaryTypeDropDownMenu.toString() + "<br>");
        selectByValueFromDropDown(salaryTypeDropDownMenu, salaryType);
    }
    public void clickOnAcceptCookie(){
        Reporter.log("Clicking on Accept Cookies : " + acceptCookis.toString());
        switchToiFrame("gdpr-consent-notice");
        clickOnElement(acceptCookis);
    }
    public void selectJobType(String jobType) {
        Reporter.log("Selecting JobType"+jobType+" from dropdown "+jobTypeDropDown.toString() + "<br>");
        selectByVisibleTextFromDropDown(jobTypeDropDown, jobType);
    }
    public void clickOnFindJobsButton() {
        Reporter.log("Clicking on FindJobsButton"+ findJobsButton.toString()+ "<br>");
        clickOnElement(findJobsButton);
    }










}
