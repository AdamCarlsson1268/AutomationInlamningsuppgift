package baskeballEngland;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;

import java.time.Duration;
import java.util.UUID;


import static org.junit.Assert.assertEquals;


public class baskeballEngland {

    WebDriver driver;
    boolean skipLastName = false;
    boolean skipTermsAndConditions = false;
    boolean mismatchPassword = false;
    private WebDriverWait wait;


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        System.out.println("Driver stängs efter scenario");
    }


    @Given("Jag navigerar till {string}")
    public void jagNavigerarTill(String arg0) {
        driver = new ChromeDriver();
        driver.get(arg0);
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    @When("Jag skriver in mina uppgifter")
    public void jagSkriverInMinaUppgifter() {
        fyllIUppgifter();
    }

    @When("Jag skriver in mina uppgifter utan efternamn")
    public void jagSkriverInMinaUppgifterUtanEfternamn() {
        skipLastName = true;
        System.out.println("skiplastname är satt till: " + skipLastName);
        fyllIUppgifter();
    }

    @When("Jag skriver in uppgifter med olika lösen")
    public void jagSkriverInUppgifterMedOlikaLosen() {
        mismatchPassword = true;
        System.out.println("mismatchPassword är satt till: true");
        fyllIUppgifter();
    }

    @When("Jag skriver in mina uppgifter utan att klicka i TAC")
    public void jagSkriverInMinaUppgifterUtanAttKlickaITAC() {
        skipTermsAndConditions = true;
        System.out.println("skipTermsAndConditions är satt till: " + skipTermsAndConditions);
        fyllIUppgifter();

    }


    private void fyllIUppgifter() {

        UUID uuid = UUID.randomUUID();
        String randomEmail = uuid + "@gmail.com";

        wait.until(ExpectedConditions.elementToBeClickable(By.id("dp")));
        driver.findElement(By.id("dp")).sendKeys("02/03/1999", Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("member_firstname")));
        driver.findElement(By.id("member_firstname")).sendKeys("Testaren", Keys.ENTER);

        if (!skipLastName) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("member_lastname")));
            driver.findElement(By.id("member_lastname")).sendKeys("Testaresson", Keys.ENTER);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.id("member_emailaddress")));
        driver.findElement(By.id("member_emailaddress")).sendKeys(randomEmail, Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("member_confirmemailaddress")));
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(randomEmail, Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("signupunlicenced_password")));
        if (mismatchPassword) {
            driver.findElement(By.id("signupunlicenced_password")).sendKeys("Testare456", Keys.ENTER);
        } else {
            driver.findElement(By.id("signupunlicenced_password")).sendKeys("Testare123", Keys.ENTER);
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("signupunlicenced_confirmpassword")));
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Testare123", Keys.ENTER);


        if (!skipTermsAndConditions) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/label/span[3]")));
            driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/label/span[3]")).click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[2]/label/span[3]")));
        driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[2]/label/span[3]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[7]/label/span[3]")));
        driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[7]/label/span[3]")).click();
    }

    @And("Jag skickar in uppgifterna")
    public void jagSkickarInUppgifterna() {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("join")));
        driver.findElement(By.name("join")).click();


    }

    @Then("Jag får ett bekräftelsemeddelnande")
    public void jagFarEttBekraftelsemeddelnande() {
        try {
            String expectedTitle = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
            WebElement actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/h2")));
            assertEquals("Rätt meddelande visas", expectedTitle, actualTitle.getText());
        } catch (TimeoutException e) {
            throw new TimeoutException("Hittade inte loacatorn inom tidsramen");

        }

    }

    @Then("Jag får ett felmeddelande om efternamn")
    public void jagFarEttFelmeddelandeOmEfternamn() {
        try {
            String expectedMessage = "Last Name is required";
            WebElement actualMesssage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signup_form\"]/div[5]/div[2]/div/span/span")));
            assertEquals("Rätt meddelande visas", expectedMessage, actualMesssage.getText());
        } catch (TimeoutException e) {
            throw new TimeoutException("Hittade inte loacatorn inom tidsramen");
        }
    }

    @Then("Jag får ett felmeddelande om lösenord som inte matchar")
    public void jagFarEttFelmeddelandeOmLosenord() {
        try {
            String expectedMessage = "Password did not match";
            WebElement actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signup_form\"]/div[8]/div/div[2]/div[2]/div/span/span")));
            assertEquals("Rätt meddelande ska visas", expectedMessage, actualMessage.getText());
        } catch (TimeoutException e) {
            throw new TimeoutException("Hittade inte loacatorn inom tidsramen");
        }
    }

    @Then("Jag får ett felmeddelande om TAC")
    public void jagFarEttFelMeddelandeOmTAC() {
        try {
            String expectedMessage = "You must confirm that you have read and accepted our Terms and Conditions";
            WebElement actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/span/span")));
            assertEquals("Rätt meddelande visas", expectedMessage, actualMessage.getText());
        } catch (TimeoutException e) {
            throw new TimeoutException("Hittade inte loacatorn inom tidsramen");
        }
    }
}


