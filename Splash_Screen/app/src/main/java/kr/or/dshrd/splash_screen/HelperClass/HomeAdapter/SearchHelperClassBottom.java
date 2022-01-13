package kr.or.dshrd.splash_screen.HelperClass.HomeAdapter;

public class SearchHelperClassBottom {

    int image;
    String title, content, rating;

    public SearchHelperClassBottom(int image, String title, String content, String rating) {
        this.image = image;
        this.title = title;
        this.content = content;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getRate() {
        return rating;
    }
}