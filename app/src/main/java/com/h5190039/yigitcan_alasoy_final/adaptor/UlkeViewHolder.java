package com.h5190039.yigitcan_alasoy_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190039.yigitcan_alasoy_final.R;

public class UlkeViewHolder extends RecyclerView.ViewHolder {

    ImageView imgUlkeBayrak;
    TextView txtUlkeAdi,txtUlkeKurulus,txtUlkeKurucusu,txtUlkeNufus;


    public UlkeViewHolder(@NonNull View cardView,UlkeAdapter.OnItemClickListener cardItemClickListener) {
        super(cardView);
        imgUlkeBayrak=cardView.findViewById(R.id.imgUlkeBayrak);
        txtUlkeAdi=cardView.findViewById(R.id.TextView);
        txtUlkeKurulus=cardView.findViewById(R.id.txtUlkeKurulus);
        txtUlkeKurucusu=cardView.findViewById(R.id.textView8);
        txtUlkeNufus=cardView.findViewById(R.id.txtUlkeNufus);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardItemClickListener.onClick(getAdapterPosition());
            }
        });
    }


}
