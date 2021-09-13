package testCases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import singletonSession.Session;

public class Login {

    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();

    @BeforeEach
    public void before() {
        Session.getSession().getDriver().get("https://todoist.com");
    }

    @AfterEach
    public void after() {
        Session.getSession().closeSession();
    }

    @Test
    public void verifyTheLogin() {
        mainPage.loginButton.click();
        loginModal.emailTxt.fillText("junior.250292@gmail.com");
        loginModal.passwordTxt.fillText("12345678");
        loginModal.loginButton.click();

        //verificación
        Assertions.assertFalse(loginModal.loginButton.isControlDisplayed(), "Error, no ingresó al sistema");
    }
}
