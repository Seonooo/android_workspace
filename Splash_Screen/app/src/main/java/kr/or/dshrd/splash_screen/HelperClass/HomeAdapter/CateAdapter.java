package kr.or.dshrd.splash_screen.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.or.dshrd.splash_screen.R;

public class CateAdapter extends RecyclerView.Adapter<CateAdapter.CateViewHolder>  {

    // 배열 선언
    ArrayList<CateHelperClass> cateLocation;

    public CateAdapter(ArrayList<CateHelperClass> cateLocation){
        this.cateLocation = cateLocation;
    }

    @NonNull
    @Override
    public CateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cate_card_design,parent,false);
        CateViewHolder cateViewHolder = new CateViewHolder(view);
        return cateViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CateViewHolder holder, int position) {

        CateHelperClass cateHelperClass = cateLocation.get(position);
        holder.image.setImageResource(cateHelperClass.getImage());
        holder.title.setText(cateHelperClass.getTitle());
        holder.relativeLayout.setBackground(cateHelperClass.getGradient());

    }

    @Override
    public int getItemCount() {
        return cateLocation.size();
    }

    public static class CateViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;
        RelativeLayout relativeLayout;

        public CateViewHolder(@NonNull View itemView) {
            super(itemView);

            // Hooks
            image = itemView.findViewById(R.id.cate_image);
            title = itemView.findViewById(R.id.cate_title);
            relativeLayout = itemView.findViewById(R.id.cate_background_gradient);
        }
    }

}
