package stepDefinitions2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import todo.TodoList;

import static org.junit.Assert.*;

public class newStepDefs {

    private TodoList todoList;
    private static int count = 1;

    @Before
    public void setUp() {
        System.out.println("setting up before scenario" + count);
        count++;
    }


    @Given("I have a todolist")
    public void iHaveATodolist() {

        todoList = new TodoList();
        assertNotNull(todoList);

    }

    @When("User adds new stuff to list with description {string}")
    public void userAddsNewStuffToListWithDescription(String description) {
        todoList.addTask(description);

    }

    @Then("The todolist contains task {string}")
    public void theTodolistContainsTask(String expected) {

        String actual = todoList.getList();

        assertEquals(expected,actual);

    }

    @When("I mark the task as done")
    public void iMarkTheTaskAsDone() {
        todoList.completeTask(0);

    }

    @Then("the task is displayed as done")
    public void theTaskIsDisplayedAsDone() {
        assertTrue(todoList.isTaskFinished(0));

    }

    @Then("Tasks in the todolist should align {int}")
    public void tasksInTheTodolistShouldAlign(int expected) {
        int actual = todoList.getNbrOfTasks();
        assertEquals(expected, actual);

    }

    @Then("Completed tasks should be {int}")
    public void completedTasksShouldBe(int expected) {
        int actual = todoList.getFinishedTasks();
        assertEquals(expected, actual);

    }

    @After
    public void tearDown() {
        System.out.println("tearing down after scenario");
    }
}


