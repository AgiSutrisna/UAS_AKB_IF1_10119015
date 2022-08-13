package com.example.uas_akb_if1_10119015.Adapter;

/*
    Nama    : Agi Sutrisna
    Nim     : 10119015
    Kelas   : IF1
 */


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas_akb_if1_10119015.DetailActivity;
import com.example.uas_akb_if1_10119015.Notebook;
import com.example.uas_akb_if1_10119015.R;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Notebook> notes;

    public Adapter(Context context, List<Notebook> notes){
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_view,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String title = notes.get(position).getTitle();
        String category = notes.get(position).getCategory();
        String date = notes.get(position).getDate();
        String time = notes.get(position).getTime();
        viewHolder.nTitle.setText(title);
        viewHolder.nCategory.setText(category);
        viewHolder.nDate.setText(date);
        viewHolder.nTime.setText(time);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView nTitle,nCategory, nDate, nTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nTitle =itemView.findViewById(R.id.nTitle);
            nCategory = itemView.findViewById(R.id.nCategory);
            nDate = itemView.findViewById(R.id.nDate);
            nTime = itemView.findViewById(R.id.nTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DetailActivity.class);
                    intent.putExtra("ID",notes.get(getAdapterPosition()).getID());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
