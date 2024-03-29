package com.cie.tests;

import com.cie.pages.MovieAppPage;
import com.cie.utils.Driver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieAppTest_1_2_3 {


    MovieAppPage movieAppPage = new MovieAppPage();


    /**
     Users will be able to view a list of popular movies.
     Movie list should be the primary screen when app is launched.
     List can be sorted by Title, Release Date and Popularity Score.
     */

    @Test
    @Order(1)
    public void viewPopularMoviesTest()  {


        String headerText = movieAppPage.header.getText();
        Assertions.assertEquals("MovieApp", headerText);

        //This will show the change on the header from "MovieApp" to "Popular" when switching tabs
        movieAppPage.favoritesTab.click();
        movieAppPage.popularTab.click();

        String headerText2 = movieAppPage.header.getText();
        Assertions.assertEquals("Popular", headerText2);

        movieAppPage.sortBtn.click();

        String sortByText = movieAppPage.sortByBox.favoriteBtn.getText();

        //This test will fail because the Sort By Box only has Title and Release Date as categories
        Assertions.assertEquals("Sort By\nTitle\nRelease Date\nPoularity", sortByText);

        //This will assert that Title and Release Date are sortable options
        Assertions.assertTrue(movieAppPage.titleSort.isEnabled());
        Assertions.assertTrue(movieAppPage.releaseDateSort.isEnabled());

        //With the sort box still open, we will now click on both Title and Release Date
        movieAppPage.titleSort.click();
        String movieFirstAlphabet = movieAppPage.getTitleOfMovieNumber_(1);

        //Asserts Doctor Strange is at the top of the Title Alphabet list
        Assertions.assertEquals("Doctor Strange in the Multiverse of Madness", movieFirstAlphabet);

        movieAppPage.sortBtn.click();
        movieAppPage.releaseDateSort.click();
        String movieReleaseDate = movieAppPage.getTitleOfMovieNumber_(1);

        //Asserts Thor is the newest released movie
        Assertions.assertEquals("Thor: Love and Thunder", movieReleaseDate);


    }




    /**     Users will be able to view a list of favorite movies.
        User can remove a movie from favorites from this list.
     */
    @Test
    @Order(2)
    public void viewAndRemoveAFavoriteMovieTest() {

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

        movieAppPage.removeFavoriteMovieNumber_(1);


        List<MobileElement> favoriteMovieCount = Driver.getDriver().findElements(By.xpath(
                "//tr[@class='Favorite_Movie_Number_']"));//the last portion of this Xpath is the
        //favorite movie number I'm counting

        int num = 0;

        for (MobileElement mobileElement : favoriteMovieCount) {
            if(mobileElement.isDisplayed()){
                num++;
            }
        }

        //Will assert how there are two movies left on my favorite list
        Assertions.assertEquals(2, num);


    }




    /**    • Users will be able to view movie details.
        o Details screen will include movie title, tags, description, banner image, poster image,
     popularity rating, and a list of Similar Movies.
     */

    @Test
    @Order(3)
    public void viewMovieDetailsTest()  {

        movieAppPage.clickMovieNumber_(1);
        String movieDetails = movieAppPage.header.getText();
        Assertions.assertEquals("Movie Details", movieDetails);


        String movieTitle = movieAppPage.movieDescriptionTitle.getText();
        Assertions.assertEquals("Thor: Love and Thunder", movieTitle);

        String genre = movieAppPage.genre.getText();
        Assertions.assertEquals("Action,Adventure,Fantasy", genre);

        String tagLine = movieAppPage.movieTagLine.getText();
        Assertions.assertEquals("The one is not the only.", tagLine);

        String description = movieAppPage.movieDescription.getText();
        Assertions.assertEquals("After his retirement is.......yada yada", description);

        String popularityRating = movieAppPage.movieScore.getText();
        double d = Double.parseDouble(popularityRating);
        Assertions.assertEquals(6.9, d);

        Assertions.assertTrue(movieAppPage.bannerImage.isDisplayed());
        Assertions.assertTrue(movieAppPage.PosterImage.isDisplayed());


        List<MobileElement> similarMovieCount = Driver.getDriver().findElements(By.xpath(
                "//tr[@class='Similar_Movie_Number_']"));//the last portion of this Xpath is the
        //similar movie number I'm counting

        int num = 0;

        for (MobileElement mobileElement : similarMovieCount) {
            if(mobileElement.isDisplayed()){
                num++;
            }
        }

        //Will assert how there are three movies on my similar ist
        Assertions.assertEquals(3, num);

    }

    @AfterEach
    public void cleanUp() {Driver.closeDriver();}


}
