package com.h5190039.yigitcan_alasoy_final.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190039.yigitcan_alasoy_final.R;

public class GlideUtil {
    public static void resmiIndiripGoster(Context context, String resimUrl, ImageView imageView){

        Glide.with(context.getApplicationContext())
                .load(resimUrl)
                .error(R.drawable.error)
                .into(imageView);
    }
}
