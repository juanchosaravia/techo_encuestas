package com.droidcba.techorelevamiento.features.api;

import retrofit.RestAdapter;

/**
 * Created by juancho on 6/6/15.
 */
public class APIRestImpl implements APIRest {

    private APIRest.TechoService techoService;

    public APIRestImpl() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://techos-encuestas.herokuapp.com")
                .build();

        techoService = restAdapter.create(APIRest.TechoService.class);
    }

    public APIRest.TechoService getTechoService() {
        return techoService;
    }
}