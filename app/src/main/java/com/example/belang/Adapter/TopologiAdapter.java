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

import com.example.belang.Activity_Details.TopologiJaringanDetails;
import com.example.belang.R;
import com.example.belang.model.materi;

import java.util.ArrayList;

public class TopologiAdapter extends RecyclerView.Adapter<TopologiAdapter.MyViewHolder> {
    Context context;
    ArrayList<materi> topologiArrayList = new ArrayList<>();

    public TopologiAdapter(Context context, ArrayList<materi> topologiArrayList) {
        this.context = context;
        this.topologiArrayList = topologiArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topologi_style,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }
@Override
    public void onBindViewHolder(MyViewHolder holder, final int position){
        final materi TopologiMateri = topologiArrayList.get(position);

        holder.tv_judul.setText(TopologiMateri.getJudul());
        holder.tv_deskripsi.setText(TopologiMateri.getDeskripsi());
        holder.img_foto.setImageResource(TopologiMateri.getFoto());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TopologiJaringanDetails.class);
                intent.putExtra("Judul", TopologiMateri.getJudul());
                intent.putExtra("Deskripsi", TopologiMateri.getDeskripsi());
                intent.putExtra("Image", TopologiMateri.getFoto());
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount(){
        return topologiArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView tv_judul, tv_deskripsi;
        ImageView img_foto;
        RelativeLayout relativeLayout;

        public MyViewHolder(View itemView){
            super(itemView);

            img_foto = (ImageView) itemView.findViewById(R.id.foto3);
            tv_judul = (TextView) itemView.findViewById(R.id.judul3);
            tv_deskripsi = (TextView) itemView.findViewById(R.id.deskripsi3);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutDasar3);
        }
    }
}
