package stepDefinitions;

import commons.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class MyStepdefs {

    private Calculator calculator;



    @Given("I have two number {} and {}")
    public void iHaveTwoNumberAnd(double first, double second) {

        calculator = new Calculator(first, second);

        System.out.println("I have two numbers");
    }

    @When("I add the two numbers")
    public void iAddTheTwoNumbers() {

        calculator.add();

        System.out.println("adding numbers");
    }

    @Then("I get the result {double}")
    public void iGetTheResult(double expected) {

        double actual = calculator.getResult();

        System.out.println("and get result");

        assertEquals(expected,actual, 0.001);



    }

    @When("I sub the two numbers")
    public void iSubTheTwoNumbers() {
        calculator.sub();
    }



}
