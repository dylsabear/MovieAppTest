package com.cie.tests;

import com.cie.pages.MovieAppPage;
import com.cie.utils.Driver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.List;

public class MovieAppTest_4 {

    MovieAppPage movieAppPage = new MovieAppPage();

        /**• Users will be able to manage a list of “favorite movies”.
    o The user can add/remove movies from their favorites.
    o Favorite movies should persist between application sessions.
    o The user can view all their favorite movies within the “Favorites” tab.
         */


    @BeforeEach
    public void manageFavoriteMovieTest(){
        movieAppPage.clickMovieNumber_(1);
        movieAppPage.favoriteBtn.click();
        movieAppPage.okButton.click();

        movieAppPage.clickMovieNumber_(2);
        movieAppPage.favoriteBtn.click();
        movieAppPage.okButton.click();

        movieAppPage.clickMovieNumber_(3);
        movieAppPage.favoriteBtn.click();
        movieAppPage.okButton.click();

        movieAppPage.favoritesTab.click();
        String movie1 = movieAppPage.getTitleOfMovieNumber_(1);
        String movie2 = movieAppPage.getTitleOfMovieNumber_(2);
        String movie3 = movieAppPage.getTitleOfMovieNumber_(3);

        Assertions.assertEquals("Thor: Love and Thunder", movie1);
        Assertions.assertEquals("Jurassic World Dominion", movie2);
        Assertions.assertEquals("The Black Phone", movie3);

        Driver.closeDriver();
    }



    //This will reopen the app to make sure all the favorite movies are still on the app
    @Test
    public void revisitingMovieAppAndCheckFavoritesTest(){

        movieAppPage.favoritesTab.click();


        String movie1 = movieAppPage.getTitleOfMovieNumber_(1);
        String movie2 = movieAppPage.getTitleOfMovieNumber_(2);
        String movie3 = movieAppPage.getTitleOfMovieNumber_(3);

        Assertions.assertEquals("Thor: Love and Thunder", movie1);
        Assertions.assertEquals("Jurassic World Dominion", movie2);
        Assertions.assertEquals("The Black Phone", movie3);

        List<MobileElement> favoriteMovieCount = Driver.getDriver().findElements(By.xpath(
                "//tr[@class='Favorite_Movie_Number_']"));//the last portion of this Xpath is the
        //favorite movie number I'm counting

        int num = 0;

        for (MobileElement mobileElement : favoriteMovieCount) {
            if(mobileElement.isDisplayed()){
                num++;
            }
        }

        //Will assert how there are three movies on my favorite list
        Assertions.assertEquals(3, num);



    }

    @AfterEach
    public void cleanUp() {Driver.closeDriver();}

}
