package pages;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@Log
public class CreateEntityPage extends BasePage {

    @FindBy(id = "entityType")
    public Select entityType;

    @FindBy(id = "entityName")
    public WebElement entityName;

    @FindBy(id = "entityNameCounter")
    public WebElement entityNameCounter;

    @FindBy(id = "privateCheckBox")
    public WebElement privateCheckBox;

    @FindBy(id = "blackBoxName")
    public WebElement blackBoxName;

    @FindBy(id = "blackBoxNameCounter")
    public WebElement blackBoxNameCounter;

    @FindBy(id = "nextButton")
    public WebElement nextButton;

    public void allElementsDisplayed() {
        log.info("All Elements found");
    }

    public void enterEntityName(String name) {
        entityName.sendKeys(name);
    }

    public void selectEntityType(String name) {
        entityType.selectByVisibleText(name);
    }

    public void checkPrivateCheckBox() {
        privateCheckBox.click();
    }

    public void enterBlackBoxName(String name) {
        blackBoxName.sendKeys(name);
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void assertBlackBoxNameText(String text) {
        assertThat(blackBoxName.getText(), is(equalTo(text)));
    }

    public void assertBlackBoxCounterText(String text) {
        assertThat(blackBoxNameCounter.getText(), is(equalTo(text)));
    }

    public void assertEntityNameCounterText(String text) {
        assertThat(entityNameCounter.getText(), is(equalTo(text)));
    }

    public void assertEntityNameText(String text) {
        assertThat(entityName.getText(), is(equalTo(text)));

    }

    public CreateEntityPage(WebDriver driver) throws Exception {
        super(driver);
        PageFactory.initElements(driver, this);
    }


}
