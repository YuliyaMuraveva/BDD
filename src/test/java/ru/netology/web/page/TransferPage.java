package ru.netology.web.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

@Name("Страница перевода")
public class TransferPage extends AkitaPage {
    @FindBy(css = "[data-test-id='amount'] .input__control")
    private SelenideElement amount;
    @FindBy(css = "[data-test-id='from'] .input__control")
    private SelenideElement from;
    @FindBy(css = "[data-test-id=action-transfer]")
    private SelenideElement transfer;

    public DashboardPage transfer(String sum, String card) {
        amount.sendKeys(Keys.chord(Keys.SHIFT, Keys.UP), Keys.DELETE);
        amount.setValue(sum);
        from.sendKeys(Keys.chord(Keys.SHIFT, Keys.UP), Keys.DELETE);
        from.setValue(card);
        transfer.click();
        return Selenide.page(DashboardPage.class);
    }
}
