package com.mobilebees.techgeeks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private Context context;
    private int images[];
    private String names[];

    public MyAdapter(Context context, int[] images, String[] names) {
        this.context = context;
        this.images = images;
        this.names = names;
    }

    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_layout,null);
        MyHolder myHolder= new MyHolder(layout);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder viewHolder, int i) {
        viewHolder.img.setImageResource(images[i]);
        viewHolder.txt.setText(names[i]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView img;
        TextView txt;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            txt = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener((View.OnClickListener) this);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"you have selected the category no"+getAdapterPosition(),Toast.LENGTH_LONG).show();
                }
            });

           txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"you have selected the category no"+getAdapterPosition(),Toast.LENGTH_LONG).show();
                }
            });
        }


        @Override
        public void onClick(View v) {
            Toast.makeText(context, "You store item for item position "+ getAdapterPosition(),
                    Toast.LENGTH_LONG).show();
        }
    }
}
