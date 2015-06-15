package com.droidcba.techorelevamiento.features.api;

import com.droidcba.techorelevamiento.features.api.models.FamilyDAO;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by juancho on 6/6/15.
 */
public interface APIRest {
    TechoService getTechoService();

    interface TechoService {
        @GET("/api/family")
        Observable<List<FamilyDAO>> getFamilies();

        @Headers("Content-Type: application/json")
        @POST("/api/family")
        Observable<Void> addFamily(@Body FamilyDAO newFamily);
    }
}
