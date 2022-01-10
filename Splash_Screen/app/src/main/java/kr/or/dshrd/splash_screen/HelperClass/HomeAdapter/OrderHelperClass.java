package kr.or.dshrd.splash_screen.HelperClass.HomeAdapter;

import android.widget.RatingBar;

public class OrderHelperClass {

    int image;
    String title, description;
    RatingBar ratingBar;

    public OrderHelperClass(int image, String title, RatingBar ratingBar , String description ) {
        this.image = image;
        this.title = title;
        this.ratingBar = ratingBar;
        this.description = description;
    }


    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public RatingBar getRatingBar() {
        return ratingBar;
    }

    public String getDescription() {
        return description;
    }
}
