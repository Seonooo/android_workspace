package kr.or.dshrd.challenge.HelperClass;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Dictionary;

import kr.or.dshrd.challenge.R;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ItemViewHolder>  {

    // 배열 선언
    private ArrayList<ItemHelperClass> itemLocation;
    private Context context;

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

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{

        protected TextView title, no, content, date;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            // Hooks
            no = itemView.findViewById(R.id.item_no);
            title = itemView.findViewById(R.id.item_title);
            content = itemView.findViewById(R.id.item_content);
            date = itemView.findViewById(R.id.item_date);

            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            MenuItem Edit = contextMenu.add(Menu.NONE, 1001, 1, "Edit");
            MenuItem Delete = contextMenu.add(Menu.NONE, 1002, 2, "Delete");
            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);

        }

        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case 1001 :
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        View view = LayoutInflater.from(context).inflate(R.layout.add_dialog, null, false);
                        builder.setView(view);
                        final Button editBtn = (Button) view.findViewById(R.id.dialog_add);
                        final EditText editNo = (EditText) view.findViewById(R.id.dialog_no);
                        final EditText edit_title = (EditText) view.findViewById(R.id.dialog_title);
                        final EditText editContent = (EditText) view.findViewById(R.id.dialog_content);
                        final EditText editDate = (EditText) view.findViewById(R.id.dialog_date);

                        editNo.setText(itemLocation.get(getAdapterPosition()).getNo());
                        edit_title.setText(itemLocation.get(getAdapterPosition()).getTitle());
                        editContent.setText(itemLocation.get(getAdapterPosition()).getContent());
                        editDate.setText(itemLocation.get(getAdapterPosition()).getDate());

                        final AlertDialog dialog = builder.create();
                        editBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String strNo = editNo.getText().toString();
                                String strTitle = edit_title.getText().toString();
                                String strContent = editContent.getText().toString();
                                String strDate = editDate.getText().toString();

                                ItemHelperClass dict = new ItemHelperClass(strNo, strTitle, strContent, strDate);

                                itemLocation.set(getAdapterPosition(), dict);

                                notifyItemChanged(getAdapterPosition());
                                dialog.dismiss();
                            }
                        });

                        dialog.show();

                        break;

                    case 1002:
                        itemLocation.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(), itemLocation.size());
                        break;


                }
                return true;
            }
        };
    }

}