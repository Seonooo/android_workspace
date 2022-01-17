package kr.or.dshrd.challenge.HelperClass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.or.dshrd.challenge.R;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ItemViewHolder>  {

    // 배열 선언
    ArrayList<ItemHelperClass> itemLocation;

    public itemAdapter(ArrayList<ItemHelperClass> itemLocation){
        this.itemLocation = itemLocation;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        ItemHelperClass itemHelperClass = itemLocation.get(position);
        holder.no.setText(itemHelperClass.getNo());
        holder.title.setText(itemHelperClass.getTitle());
        holder.content.setText(itemHelperClass.getContent());
        holder.date.setText(itemHelperClass.getDate());

    }

    @Override
    public int getItemCount() {
        return itemLocation.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView no;
        TextView content;
        TextView date;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            // Hooks
            no = itemView.findViewById(R.id.item_no);
            title = itemView.findViewById(R.id.item_title);
            content = itemView.findViewById(R.id.item_content);
            date = itemView.findViewById(R.id.item_date);
        }
    }

}