package com.h5190039.yigitcan_alasoy_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190039.yigitcan_alasoy_final.model.UlkeModel;
import com.h5190039.yigitcan_alasoy_final.R;
import com.h5190039.yigitcan_alasoy_final.utils.GlideUtil;

import java.util.List;

public class UlkeAdapter extends RecyclerView.Adapter<UlkeViewHolder> {

    List<UlkeModel> ulkeler;
    Context context;
    OnItemClickListener cardItemClickListener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public UlkeAdapter(List<UlkeModel> ulkeler, Context context,OnItemClickListener cardItemClickListener){
        this.ulkeler=ulkeler;
        this.context=context;
        this.cardItemClickListener=cardItemClickListener;
    }

    @NonNull
    @Override
    public UlkeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ulke,parent,false);
        return new UlkeViewHolder(itemView,cardItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UlkeViewHolder viewHolder, int position) {
        viewHolder.txtUlkeAdi.setText(ulkeler.get(position).getUlkeAdi());
        viewHolder.txtUlkeKurucusu.setText(ulkeler.get(position).getKurucusu());
        viewHolder.txtUlkeKurulus.setText(ulkeler.get(position).getKurulus());
        viewHolder.txtUlkeNufus.setText(ulkeler.get(position).getNufus());

        GlideUtil.resmiIndiripGoster(context,ulkeler.get(position).getBayrakUrl(),viewHolder.imgUlkeBayrak);

    }

    @Override
    public int getItemCount() {
        return ulkeler.size();
    }
}
