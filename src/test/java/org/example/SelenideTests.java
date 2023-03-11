package org.example;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTests {

    @Test
    public void openFormTest() {
        Configuration.startMaximized = true;
//        Configuration.browser = "firefox";
        open("https://demoqa.com/automation-practice-form");
    }


}
