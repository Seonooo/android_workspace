package kr.or.dshrd.splash_screen.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.or.dshrd.splash_screen.R;

public class SearchBottomAdapter extends RecyclerView.Adapter<SearchBottomAdapter.SearchViewHolder>  {

    // 배열 선언
    ArrayList<SearchHelperClassBottom> searchLocation;

    public SearchBottomAdapter(ArrayList<SearchHelperClassBottom> searchLocation){
        this.searchLocation = searchLocation;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card_bottom_design,parent,false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        SearchHelperClassBottom searchHelperClass = searchLocation.get(position);
        holder.image.setImageResource(searchHelperClass.getImage());
        holder.title.setText(searchHelperClass.getTitle());
        holder.rating.setText(searchHelperClass.getRate());
        holder.content.setText(searchHelperClass.getContent());

    }

    @Override
    public int getItemCount() {
        return searchLocation.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, rating, content;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            // Hooks
            image = itemView.findViewById(R.id.search_bottom_img);
            title = itemView.findViewById(R.id.search_bottom_title);
            content = itemView.findViewById(R.id.search_bottom_content);
            rating = itemView.findViewById(R.id.search_bottom_rating);
        }
    }

}