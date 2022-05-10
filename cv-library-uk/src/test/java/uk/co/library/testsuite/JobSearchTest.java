package uk.co.library.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.TestBase;

public class JobSearchTest extends TestBase {
    HomePage homePage;
    ResultPage resultPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        resultPage = new ResultPage();

    }

    @Test(dataProvider = "JobSearch", dataProviderClass = TestData.class,groups = {"sanity","smoke","regression"})
    public void verifyJobSearchResultUsingDifferentDataSet(
            String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String result) throws InterruptedException {
       // Thread.sleep(1000);
        homePage.clickOnAcceptCookie();
        homePage.enterJobTitle(jobTitle);
        homePage.enterLocation(location);
        homePage.selectDistance(distance);
        homePage.clickOnMoreSearchOptionLink();
        homePage.enterMinSalary(salaryMin);
        homePage.enterMaxSalary(salaryMax);
        homePage.selectSalaryType(salaryType);
        homePage.selectJobType(jobType);
        homePage.clickOnFindJobsButton();
        //homePage.setAcceptCookis();
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(resultPage.verifyTheResults(),result,"");
        softAssert.assertAll();

    }
}
