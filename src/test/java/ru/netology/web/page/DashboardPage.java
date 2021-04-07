package ru.netology.web.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import static com.codeborne.selenide.Selenide.$;

@Name("Дашбоард")
public class DashboardPage extends AkitaPage {
    @FindBy(css = "[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button")
    private SelenideElement actionCard1;
    @FindBy(css = "[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button")
    private SelenideElement actionCard2;
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public TransferPage topUpCard(String card) {
        if (card.equals("1")) {
            actionCard1.click();
        }
        else if (card.equals("2")) {
            actionCard2.click();
        }
        return Selenide.page(TransferPage.class);
    }

    public String getCardBalance(String card) {
        String id = new String();
        if (card.equals("1")) {
            id = "92df3f1c-a033-48e6-8390-206f6b1f56c0";
        }
        else if (card.equals("2")) {
            id = "0f3f5c2a-249e-4c3d-8287-09f7a039391d";
        }
        var text = $("[data-test-id='" + id + "']").text();
        return extractBalance(text);
    }

    private String extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return value;
    }

}
