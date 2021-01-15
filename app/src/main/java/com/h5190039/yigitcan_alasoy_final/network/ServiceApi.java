package com.h5190039.yigitcan_alasoy_final.network;

import com.h5190039.yigitcan_alasoy_final.model.UlkeModel;
import com.h5190039.yigitcan_alasoy_final.utils.ConstantsClass;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET(ConstantsClass.API_URL)
    Observable<List<UlkeModel>> ulkeleriGetir();

}
