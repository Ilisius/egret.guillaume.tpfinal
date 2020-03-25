package com.example.egretguillaumetpfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(@NonNull View itemView, final OnItemClick onclick)
        {
            super(itemView);

        }
    }

    public void setOnItemClickListener(OnItemClick onclick)
    {
        this.onclick = onclick;
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

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
