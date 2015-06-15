package com.droidcba.techorelevamiento.features.families;

import com.droidcba.techorelevamiento.features.api.APIRest;
import com.droidcba.techorelevamiento.features.api.APIRestImpl;
import com.droidcba.techorelevamiento.features.api.APIRestMock;
import com.droidcba.techorelevamiento.features.api.models.FamilyDAO;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by juancho on 6/6/15.
 */
public class FamilyManager {

    private APIRest api;

    public FamilyManager() {
        api = new APIRestImpl();
    }

    public Observable<List<FamilyItem>> getFamilies() {
        return api.getTechoService().getFamilies().flatMap(new Func1<List<FamilyDAO>, Observable<List<FamilyItem>>>() {
            @Override
            public Observable<List<FamilyItem>> call(List<FamilyDAO> familyDAOs) {
                List<FamilyItem> familyItems = new ArrayList<>();
                for (FamilyDAO dao : familyDAOs) {
                    familyItems.add(convert(dao));
                }

                return Observable.just(familyItems);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Void> addFamily(FamilyItem familyItem) {
        FamilyDAO newFamily = new FamilyDAO();
        newFamily.setBossFirstName(familyItem.getBossFirstName());
        newFamily.setBossLastName(familyItem.getBossLastName());
        newFamily.setStreet(familyItem.getStreet());
        newFamily.setStreetNumber(familyItem.getStreetNumber());
        newFamily.setPhone(familyItem.getPhone());
        newFamily.setLat(familyItem.getLat());
        newFamily.setLng(familyItem.getLng());

        return api.getTechoService().addFamily(newFamily)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private FamilyItem convert(FamilyDAO familyDAO) {
        FamilyItem item = new FamilyItem();
        item.setId(familyDAO.getId());
        item.setBossFirstName(familyDAO.getBossFirstName());
        item.setBossLastName(familyDAO.getBossLastName());
        item.setStreet(familyDAO.getStreet());
        item.setStreetNumber(familyDAO.getStreetNumber());
        item.setPhone(familyDAO.getPhone());

        return item;
    }
}
