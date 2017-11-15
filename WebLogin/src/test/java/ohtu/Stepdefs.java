package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Stepdefs {
    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();          
    } 

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_and_password_are_given(String username, String password) throws Throwable {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }

    @Then("^system will respond \"([^\"]*)\"$")
    public void system_will_respond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }
    
    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    
    @When("^invalid username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void invalid_username_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    
    
    
    
    
    
    @Given("^command new user is selected$")
    public void command_new_user_is_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();      
    }

    @When("^a valid username \"([^\"]*)\" and password \"([^\"]*)\" and matching password confirmation are entered$")
    public void a_valid_username_and_password_and_matching_password_confirmation_are_entered(String username, String password) throws Throwable {
        createWith(username,password);
    }

    @Then("^a new user is created$")
    public void a_new_user_is_created() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");
    }

    
    @When("^a invalid username \"([^\"]*)\" and password \"([^\"]*)\" and matching password confirmation are entered$")
    public void a_invalid_username_and_password_and_matching_password_confirmation_are_entered(String username, String password) throws Throwable {
        createWith(username,password);
    }

    @Then("^user is not created and error \"([^\"]*)\" is reported$")
    public void user_is_not_created_and_error_is_reported(String arg1) throws Throwable {
        pageHasContent("username should have at least 3 characters");
    }
    
    @When("^a valid username \"([^\"]*)\" and invalid password \"([^\"]*)\" and matching password confirmation are entered$")
    public void a_valid_username_and_invalid_password_and_matching_password_confirmation_are_entered(String username, String password) throws Throwable {
        createWith(username,password);
    }
    
    @Then("^user is not created, error \"([^\"]*)\" is reported$")
    public void user_is_not_created_error_is_reported(String arg1) throws Throwable {
        pageHasContent("password should have at least 8 characters");
    }

    @When("^a taken username \"([^\"]*)\" and valid password \"([^\"]*)\" and matching password confirmation are entered$")
    public void a_taken_username_and_valid_password_and_matching_password_confirmation_are_entered(String username, String password) throws Throwable {
        createWith(username,password);
    }
    
    @Then("^user is not created and the error \"([^\"]*)\" is reported$")
    public void user_is_not_created_and_the_error_is_reported(String arg1) throws Throwable {
        pageHasContent("username is already taken");
    }
    
    @When("^a valid username \"([^\"]*)\" and invalid password \"([^\"]*)\" and non-matching password confirmation are entered$")
    public void a_valid_username_and_invalid_password_and_non_matching_password_confirmation_are_entered(String username, String password) throws Throwable {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("vaarasalasana1234");
        element.submit();  
    }

    @Then("^user is not created leading to error \"([^\"]*)\" is reported$")
    public void user_is_not_created_leading_to_error_is_reported(String arg1) throws Throwable {
        pageHasContent("No no no, password does not match");
    }
    
    
    
    
        @Given("^user with username \"([^\"]*)\" with password \"([^\"]*)\" is successfully created$")
    public void user_with_username_with_password_is_successfully_created(String username, String password) throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();  
        
        createWith(username, password);
        
        driver.get(baseUrl);
        element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        
    }

    @When("^username and password is valid$")
    public void username_and_password_is_valid() throws Throwable {
        //pageHasContent("Ohtu Application main page");
        //logInWith(username, password);
    }

    @Given("^user with username \"([^\"]*)\" and password \"([^\"]*)\" is tried to be created$")
    public void user_with_username_and_password_is_tried_to_be_created(String username, String password) throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();  
        
        createWith(username, password);
        
        driver.get(baseUrl);
        element = driver.findElement(By.linkText("login"));       
        element.click(); 
    }

    @When("^user tries to login with bad values$")
    public void user_tries_to_login_with_bad_values() throws Throwable {
        pageHasContent("invalid username or password");
    }





    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void createWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element.submit();  
    }
    
    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" is valid$")
    public void username_and_password_is_valid(String username, String password) throws Throwable {
        logInWith(username,password);
    }

    @When("^user tries to login with bad values username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_tries_to_login_with_bad_values_username_and_password(String username, String password) throws Throwable {
        logInWith(username,password);;
    }

}
