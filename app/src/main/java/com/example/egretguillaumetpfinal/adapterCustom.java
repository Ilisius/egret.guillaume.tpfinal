package com.example.egretguillaumetpfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapterCustom extends RecyclerView.Adapter<adapterCustom.ViewHolder>
{
    private List<Pays> lPays;
    private OnItemClick onclick;

    public interface OnItemClick
    {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClick onclick)
    {
        this.onclick = onclick;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView myImgView;
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;

        public ViewHolder(@NonNull View itemView, final OnItemClick onclick)
        {
            super(itemView);
            myImgView = itemView.findViewById(R.id.image_view);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            textView3 = itemView.findViewById(R.id.text3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION)
                    {
                        onclick.onItemClick(position);
                    }
                }
            });

        }
    }

    public adapterCustom(List<Pays> lPays)
    {
        this.lPays = lPays;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v, onclick);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final Pays currentPays = lPays.get(position);
        final ViewHolder holderf = holder;
        holderf.textView1.setText(currentPays.getName());
        holderf.textView2.setText(currentPays.getRegion());
        holderf.textView3.setText(currentPays.getSubregion());


    }

    @Override
    public int getItemCount() {
        return this.lPays.size();
    }


}
