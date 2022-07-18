package com.cie.tests;

import com.cie.pages.MovieAppPage;
import com.cie.utils.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MovieAppTest_5 {

    MovieAppPage movieAppPage = new MovieAppPage();

    /**
     *  App will have tab-based navigation including Popular, New, and Favorites tabs.
     */

    @Test
    public void navigationTabTest(){

        Assertions.assertTrue(movieAppPage.favoritesTab.isDisplayed());
        Assertions.assertTrue(movieAppPage.popularTab.isDisplayed());


        Assertions.assertFalse(Driver.getDriver().findElement(MobileBy.AccessibilityId("Tab_New")).isDisplayed());

        //Since "New" is not on the bottom with "Popular" and "Favorites, this will pass as false.
        //In my pages file, you can see how "Popular" is labeled as "Tab_Popular" and vice versa with "Tab_Favorites"
        //If "New" was displayed as an option, "Tab_New" would have been seen as an accessibility ID


    }

    @AfterEach
    public void cleanUp() {Driver.closeDriver();}


}
