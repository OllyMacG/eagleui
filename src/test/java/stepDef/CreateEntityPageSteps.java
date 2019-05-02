package stepDef;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.java.Log;


import pages.CreateEntityPage;


@Log
public class CreateEntityPageSteps extends BaseSteps {
    final static String CREATE_ENITY_URL = "https://www.bbc.co.uk/";

    private CreateEntityPage createEntityPage = new CreateEntityPage(webDriver);

    public CreateEntityPageSteps() throws Exception {
    }

    @Given("^the user is on the Create Entity page$")
    public void i_am_on_the_Create_Entity_page() throws Throwable {
        webDriver.get(CREATE_ENITY_URL);
    }

    @Then("^all expected elements are displayed$")
    public void all_elements_displayed() throws Throwable {
        createEntityPage.allElementsDisplayed();
    }

    @Given("^the user selects the private box$")
    public void the_user_selects_the_private_box() throws Throwable {
        createEntityPage.checkPrivateCheckBox();
    }

    @When("^the user enters \"([^\"]*)\" as the black box name$")
    public void the_user_enters_as_the_black_box_name(String arg1) throws Throwable {
        createEntityPage.enterBlackBoxName(arg1);
    }

    @When("^the user selects the next button$")
    public void the_user_selects_the_next_button() throws Throwable {
        createEntityPage.clickNextButton();
    }

    @Then("^the black box name counter should read \"([^\"]*)\"$")
    public void the_black_box_name_counter_should_read(String arg1) throws Throwable {
        createEntityPage.assertBlackBoxCounterText(arg1);
    }

    @Then("^the entity name should read \"([^\"]*)\"$")
    public void the_entity_name_should_read(String arg1) throws Throwable {
        createEntityPage.assertEntityNameText(arg1);
    }

    @Then("^the black box name should read \"([^\"]*)\"$")
    public void the_black_box_name_should_read(String arg1) throws Throwable {
        createEntityPage.assertBlackBoxNameText(arg1);
    }


    @Then("^an entity is created$")
    public void an_entity_is_created() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the user enters \"([^\"]*)\" as the entity name$")
    public void the_user_enters_as_the_entity_name(String arg1) throws Throwable {
        createEntityPage.enterEntityName(arg1);
    }

    @Then("^no entity is created$")
    public void no_entity_is_created() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the user selects \"([^\"]*)\" as the entity type$")
    public void the_user_selects_as_the_entity_type(String arg1) throws Throwable {
        createEntityPage.selectEntityType(arg1);
    }

    @Then("^the entity name counter should read \"([^\"]*)\"$")
    public void entity_name_counter(String expectedCounter) {
        createEntityPage.assertEntityNameCounterText(expectedCounter);
    }

}
