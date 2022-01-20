package kr.or.dshrd.challenge.HelperClass;

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

import kr.or.dshrd.challenge.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int images[] ={
            R.drawable.slider_01,
            R.drawable.slider_02,
            R.drawable.slider_03,
    };

    int titles[] ={
            R.string.slide_title_01,
            R.string.slide_title_02,
            R.string.slide_title_03,
    };

    // 배열의 길이
    @Override
    public int getCount() {
        return titles.length;
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
        View view = layoutInflater.inflate(R.layout.slider, container, false);

        //Hooks
        ImageView imageView = view.findViewById(R.id.slide_img);
        TextView title = view.findViewById(R.id.slide_title);

        imageView.setImageResource(images[position]);
        title.setText(titles[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
