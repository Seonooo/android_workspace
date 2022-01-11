package kr.or.dshrd.splash_screen.HelperClass.HomeAdapter;

import android.graphics.drawable.Drawable;

public class CateHelperClass {

    int image;
    String title;
    Drawable gradient;

    public CateHelperClass(int image, String title, Drawable gradient) {
        this.image = image;
        this.title = title;
        this.gradient = gradient;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getGradient() { return gradient; }
}
