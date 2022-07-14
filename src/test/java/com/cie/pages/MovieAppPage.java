package com.cie.pages;

import com.cie.utils.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MovieAppPage {

    public MovieAppPage(){
        PageFactory.initElements(new AppiumFieldDecorator(com.cie.utils.Driver.getDriver()), this);
    }

    //This locator finds the text on the top left
    @AndroidFindBy(accessibility = "Header")
    public MobileElement header;

    @AndroidFindBy(accessibility = "Tab_Favorites")
    public MobileElement favoritesTab;

    @AndroidFindBy(accessibility = "Tab_Popular")
    public MobileElement popularTab;

    @AndroidFindBy(accessibility = "Sort")
    public MobileElement sortBtn;

    @AndroidFindBy(id = "sort_1")
    public MobileElement titleSort;

    @AndroidFindBy(id = "sort_2")
    public MobileElement releaseDateSort;

    @AndroidFindBy(accessibility = "Sort By")
    public MovieAppPage sortByBox;


    @AndroidFindBy(accessibility = "Favorite")
    public MobileElement favoriteBtn;

    @AndroidFindBy(accessibility = "Ok")
    public MobileElement okButton;

    @AndroidFindBy(accessibility = "Remove")
    public MobileElement removeFromFavoritesBtn;

    @AndroidFindBy(id = "MovieDescriptionTitle")
    public MobileElement movieDescriptionTitle;

    @AndroidFindBy(id = "Genre")
    public MobileElement genre;

    @AndroidFindBy(accessibility = "MovieTagLine")
    public MobileElement movieTagLine;

    @AndroidFindBy(accessibility = "MovieDescription")
    public MobileElement movieDescription;

    @AndroidFindBy(accessibility = "BannerImage")
    public MobileElement bannerImage;

    @AndroidFindBy(accessibility = "PosterImage")
    public MobileElement PosterImage;

    @AndroidFindBy(accessibility = "MovieScore")
    public MobileElement movieScore;

    @AndroidFindBy(accessibility = "similarMovieNumber_")//the "_" represents the missing number
    public MobileElement similarMovie;





    public void clickMovieNumber_(int digit){
        String id = "com.google.android.movieNumber:id/digit_" + digit;
        MobileElement number = Driver.getDriver().findElement(By.id(id));
        number.click();
    }

    public static String getTitleOfMovieNumber_(int digit){
        String id = "com.google.android.movieNumber:id/digit_" + digit;
        MobileElement number = Driver.getDriver().findElement(By.id(id));
        String movieTitle = number.getText();

        return movieTitle;
    }

    public void removeFavoriteMovieNumber_(int digit){
        String id = "com.google.android.removeFavoriteMovieNumber:id/digit_" + digit;
        MobileElement number = Driver.getDriver().findElement(By.id(id));
        number.click();
    }




}



