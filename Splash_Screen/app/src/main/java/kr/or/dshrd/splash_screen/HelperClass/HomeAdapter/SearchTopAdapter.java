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

public class SearchTopAdapter extends RecyclerView.Adapter<SearchTopAdapter.SearchViewHolder>  {

    // 배열 선언
    ArrayList<SearchHelperClassTop> searchLocation;

    public SearchTopAdapter(ArrayList<SearchHelperClassTop> searchLocation){
        this.searchLocation = searchLocation;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card_top_design,parent,false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        SearchHelperClassTop searchHelperClass = searchLocation.get(position);
        holder.image.setImageResource(searchHelperClass.getImage());
        holder.title.setText(searchHelperClass.getTitle());

    }

    @Override
    public int getItemCount() {
        return searchLocation.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            // Hooks
            image = itemView.findViewById(R.id.serach_top_img);
            title = itemView.findViewById(R.id.search_top_title);
        }
    }

}