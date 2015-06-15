package com.droidcba.techorelevamiento.features.api;

import com.droidcba.techorelevamiento.features.api.models.FamilyDAO;

import java.util.ArrayList;
import java.util.List;

import retrofit.http.Body;
import rx.Observable;

/**
 * Created by juancho on 6/6/15.
 */
public class APIRestMock implements APIRest {
    @Override
    public TechoService getTechoService() {
        return new TechoServiceMock();
    }

    public class TechoServiceMock implements TechoService {

        @Override
        public Observable<List<FamilyDAO>> getFamilies() {
            List<FamilyDAO> family = new ArrayList<>();

            for (int i=0; i < 20; i++) {
                family.add(new FamilyDAO(i + "", "Abel", "Martinez", "Navarra", i + "000","43243243", "-31", "-64", "Construido", "1", "Alta"));
            }

            return Observable.just(family);
        }

        @Override
        public Observable<Void> addFamily(@Body FamilyDAO newFamily) {
            return null;
        }
    }
}
