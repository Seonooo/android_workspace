package kr.or.dshrd.splash_screen.HelperClass.HomeAdapter;

public class OrderHelperClass {

    int image;
    String title, description, rating;

    public OrderHelperClass(int image, String title, String rating , String description ) {
        this.image = image;
        this.title = title;
        this.rating = rating;
        this.description = description;
    }


    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }
}
