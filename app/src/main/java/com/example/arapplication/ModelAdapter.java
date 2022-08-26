package com.example.arapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {

    String urlimage;
    Context context;
    ArrayList<ModelFirebase> modelFirebaseArrayList;
    ItemClickListener itemClickListener;

    public ModelAdapter(Context context, ArrayList<ModelFirebase> modelFirebaseArrayList, ItemClickListener itemClickListener)
    {
        this.context = context;
        this.modelFirebaseArrayList = modelFirebaseArrayList;
        this.itemClickListener = itemClickListener;
    }
    @NonNull
    @Override
    public ModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelAdapter.ViewHolder holder, int position) {
        ModelFirebase modelFirebase = modelFirebaseArrayList.get(position);
        urlimage =  modelFirebase.url;
        holder.modelname.setText(modelFirebase.model_name);
        holder.itemView.setOnClickListener(view -> {
            itemClickListener.OnItemClick(modelFirebaseArrayList.get(position));
        });
        Picasso.with(context).load(urlimage).into(holder.imgmodel);
    }

    @Override
    public int getItemCount() {
        return modelFirebaseArrayList.size();
    }

    public interface ItemClickListener
    {
        void OnItemClick(ModelFirebase modelFirebase);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView modelname;
        ImageView imgmodel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            modelname = itemView.findViewById(R.id.txtmodelname);
            imgmodel  = itemView.findViewById(R.id.imgmodel);
        }

    }
}
