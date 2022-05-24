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

import com.example.belang.Activity_Details.JenisJaringanDetails;
import com.example.belang.R;
import com.example.belang.model.materi;

import java.util.ArrayList;

public class JenisAdapter extends RecyclerView.Adapter<JenisAdapter.MyViewHolder> {

    Context context;
    ArrayList<materi> jenisArrayList = new ArrayList<>();

    public JenisAdapter(Context context, ArrayList<materi> jenisArrayList) {
        this.context = context;
        this.jenisArrayList = jenisArrayList;
    }

@Override
public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_jenis,parent,false);
    MyViewHolder viewHolder = new JenisAdapter.MyViewHolder(view);

    return viewHolder;
}
@Override
public void onBindViewHolder(JenisAdapter.MyViewHolder holder, final int position){
    final materi JenisMateri = jenisArrayList.get(position);

    holder.tv_judul.setText(JenisMateri.getJudul());
    holder.tv_deskripsi.setText(JenisMateri.getDeskripsi());
    holder.img_foto.setImageResource(JenisMateri.getFoto());
    holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, JenisJaringanDetails.class);
            intent.putExtra("Judul",JenisMateri.getJudul());
            intent.putExtra("Deskripsi",JenisMateri.getDeskripsi());
            intent.putExtra("Image",JenisMateri.getFoto());
            context.startActivity(intent);
        }
    });
}
    @Override
    public int getItemCount(){
        return jenisArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView tv_judul, tv_deskripsi;
        ImageView img_foto;
        RelativeLayout relativeLayout;

        public MyViewHolder(View itemView){
            super(itemView);

            img_foto = (ImageView) itemView.findViewById(R.id.foto2);
            tv_judul = (TextView) itemView.findViewById(R.id.judul2);
            tv_deskripsi = (TextView) itemView.findViewById(R.id.deskripsi2);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutDasar2);
        }
    }

}
