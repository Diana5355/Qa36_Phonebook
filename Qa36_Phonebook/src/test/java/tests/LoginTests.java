package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info(" I need logout");
        }

    }

    @Test
    public void loginSuccess(){
        logger.info("Login with valid data : email:noa@gmail.com & password:Nnoa12345$ ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Tests success");
    }

    @Test
    public void loginSuccessNew(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sonya@gmail.com", "Ss12345$");
        app.getHelperUser().submitLogin();
    }

    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sonyagmail.com", "Ss12345$");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));
        logger.info("Error message is : 'Wrong email or password'  ");

    }

    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sonya@gmail.com", "Ss123");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));


    }

    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("gigi@gmail.com", "Ss12345$");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));

    }
}
