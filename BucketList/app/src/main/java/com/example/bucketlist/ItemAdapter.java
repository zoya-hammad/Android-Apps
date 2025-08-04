package com.example.bucketlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.BucketListViewHolder> {

    private BucketListItem[] items;

    public ItemAdapter(BucketListItem[] items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    @NonNull
    @Override
    public BucketListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bucket_list, parent, false);
        return new BucketListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BucketListViewHolder holder, int position) {
        holder.bind(items[position]);
    }

    static class BucketListViewHolder extends RecyclerView.ViewHolder{

        private ImageView itemImg;
        private TextView itemTitle, itemDescription;
        private RatingBar itemRating;

        public BucketListViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImg = itemView.findViewById(R.id.image_view_icon);
            itemTitle = itemView.findViewById(R.id.text_view_title);
            itemDescription = itemView.findViewById(R.id.text_view_description);
            itemRating = itemView.findViewById(R.id.rating_bar);
        }

        public void bind(BucketListItem item){
            itemTitle.setText(item.title);
            itemDescription.setText(item.description);
            itemImg.setImageResource(item.image);
            itemRating.setRating(item.rating);
        }
    }
}
