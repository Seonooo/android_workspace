package kr.or.dshrd.splash_screen.HelperClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import org.w3c.dom.Text;

import kr.or.dshrd.splash_screen.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int image[] ={
      R.drawable.slider_01,
      R.drawable.slider_02,
      R.drawable.slider_03,
      R.drawable.slider_04,
    };

    int headings[] ={
            R.string.first_slider_title,
            R.string.second_slider_title,
            R.string.third_slider_title,
            R.string.fourth_slider_title,
    };

    int descriptions[] ={
            R.string.first_slider_desc,
            R.string.second_slider_desc,
            R.string.third_slider_desc,
            R.string.fourth_slider_desc,
    };

    // 배열의 길이
    @Override
    public int getCount() {
        return headings.length;
    }


    // 보여질 오브젝트의 layout의 비교
    @Override
    public  boolean isViewFromObject(@NonNull View view, @NonNull Object object){
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        //Hooks
        ImageView imageView = view.findViewById(R.id.slider_images);
        TextView heading = view.findViewById(R.id.slider_heading);
        TextView content = view.findViewById(R.id.slider_content);

        imageView.setImageResource(image[position]);
        heading.setText(headings[position]);
        content.setText(descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
