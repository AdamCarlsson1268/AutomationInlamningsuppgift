package stepDefinitions4;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyStepdefs4 {

    WebDriver driver;

    @Given("jag är på hemsidan {string}")
    public void jagArPaHemsidan(String url)throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(2000);
    }

    @When("jag söker efter en produkt {string}")
    public void jagSokerEfterEnProdukt(String arg0) {
        WebElement searchBox = driver.findElement(By.id("small-searchterms"));
        searchBox.sendKeys("Computing and Internet");
        searchBox.submit();
    }

    @And("jag lägger produkten i varukorgen")
    public void jagLaggerProduktenIVarukorgen() {
        WebElement addToCartButton = driver.findElement(By.cssSelector(".add-to-cart-button"));
        addToCartButton.click();
    }

    @And("jag går till varukorgen")
    public void jagGarTillVarukorgen() {
        WebElement cartButton = driver.findElement(By.cssSelector(".cart"));
        cartButton.click();

    }

    @And("jag klickar på {string}")
    public void jagKlickarPa(String buttonText) {
        WebElement checkOutButton = driver.findElement(By.linkText(buttonText));
        checkOutButton.click();
    }

    @And("jag fyller i mina leveransuppgifter")
    public void jagFyllerIMinaLeveransuppgifter() {
        driver.findElement(By.id("name")).sendKeys("Test User");
        driver.findElement(By.id("address")).sendKeys("Test Street 123");
        driver.findElement(By.id("zip")).sendKeys("12345");
        driver.findElement(By.id("city")).sendKeys("Test City");
    }

    @And("jag väljer betalningsmetod {string}")
    public void jagValjerBetalningsmetod(String paymentMethod) {
        if (paymentMethod.equals("Betala vid leverans")){
            WebElement paymentOption = driver.findElement(By.id("payment-method-cod"));
            paymentOption.click();
        }
    }

    @And("jag bekräftar beställningen")
    public void jagBekraftarBestallningen() {
        WebElement confirmButton = driver.findElement(By.id("confirmOrder"));
        confirmButton.click();
    }

    @Then("jag ska se en bekräftelsesida med texten {string}")
    public void jagSkaSeEnBekraftelsesidaMedTexten(String confirmationText) {
//        WebElement confirmationMessage = driver.findElement(By.xpath());
    }
}
