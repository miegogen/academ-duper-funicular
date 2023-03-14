package ru.emg.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SelenideTests {

    @Test
    public void openFormTest() {
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }
}
