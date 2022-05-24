package com.example.belang.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.belang.Activity_Details.DasarJaringanDetails;
import com.example.belang.R;
import com.example.belang.model.materi;

import java.util.ArrayList;

public class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.MyViewHolder> {

    Context context;
    ArrayList<materi>materiArrayList ;


    public MateriAdapter(Context context, ArrayList<materi> materiArrayList) {
        this.context = context;
        this.materiArrayList = materiArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view = LayoutInflater.from(context).inflate(R.layout.style_materi,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){
    holder.tv_judul.setText(materiArrayList.get(position).getJudul());
    holder.img_foto.setImageResource(materiArrayList.get(position).getFoto());
    holder.tv_deskripsi.setText(materiArrayList.get(position).getDeskripsi());
    holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent (context, DasarJaringanDetails.class);
            intent.putExtra("Judul", materiArrayList.get(position).getJudul());
            intent.putExtra("Image", materiArrayList.get(position).getFoto());
            intent.putExtra("Deskripsi", materiArrayList.get(position).getDeskripsi());
            context.startActivity(intent);
        }
    });

    }

@Override
    public int getItemCount(){
    return materiArrayList.size();
}

public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView tv_judul, tv_deskripsi, judul_bar;
        ImageView img_foto;
        RelativeLayout relativeLayout;

        public MyViewHolder(View itemView){
            super(itemView);

                img_foto = (ImageView) itemView.findViewById(R.id.foto);
                tv_judul = (TextView) itemView.findViewById(R.id.judul);
                tv_deskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
                relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutDasar);
    }
}


         }
