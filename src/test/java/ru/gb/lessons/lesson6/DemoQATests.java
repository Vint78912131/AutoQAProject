package ru.gb.lessons.lesson6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lessons.lesson6.pages.*;

public class DemoQATests extends DemoQABaseTest{

    @Test
    @DisplayName("LogIn user:ivan password:P@$$w0rd")
    void logInDemoQATest() {

        BookStorePage test1 = new BookStorePage(webDriver);
        test1.goToLogin();
        test1.sentUserName(LOGIN);
        test1.sentPassword(PASSWORD);
        test1.logIn();
        test1.logOut();
    }


    @Test
    @DisplayName("Find books by word")
    void findBookDemoQATest() {
        BookStorePage test2 = new BookStorePage(webDriver);
        test2.findBook("book");
        test2.findBook("java");
    }

    @Test
    @DisplayName("Select all elements")
    void selectElementsDemoQATest() {
        SelectablePage test3 = new SelectablePage(webDriver);
        test3.goToGrid();
        test3.clickAllElements();
        test3.goToList();
        test3.clickAllElements();
    }

    @Test
    @DisplayName("Send keys test")
    void sendKeysDemoQATest() {
        TextBoxPage test4 = new TextBoxPage(webDriver);
        test4.sentUserName("Feodor Alibabaevich");
        test4.sentUserEmail("gentlemensOfGoodLuck@gmail.com");
        test4.sentCurrentAddress("г. Москва, ул. Тверская, д.1, кв.1");
        test4.sentPermanentAddress("г. Тверь, ул. Московская, д.1, кв.1");
        test4.clickSubmitButton();
    }


    @Test
    @DisplayName("Radio button test")
    void radioButtonDemoQATest() {
        RadioButtonPage test5 = new RadioButtonPage(webDriver);
        test5.clickYesButton();
        test5.clickImpressiveButton();
    }


    @Test
    @DisplayName("Web table test")
    void webTableDemoQATest() {
        WebTablesPage test6 = new WebTablesPage(webDriver);
        test6.clickAddButton();
        test6.sentFirstName("Pavlik");
        test6.sentLastName("Morozov");
        test6.sentUserEmail("funnyStories@gmail.com");
        test6.sentAge("21");
        test6.sentSalary("3000");
        test6.sentDepartment("QA department");
        test6.clickSubmitButton();
    }

    @Test
    @DisplayName("Mouse buttons click test")
    void mouseButtonsClickDemoQATest() {
        ButtonsPage test7 = new ButtonsPage(webDriver);
        test7.clickRightClickBtn();
        test7.clickDoubleClickButton();
        test7.clickSimpleClickBtn();
    }

}
