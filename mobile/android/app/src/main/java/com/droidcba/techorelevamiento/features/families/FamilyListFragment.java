package com.droidcba.techorelevamiento.features.families;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.droidcba.techorelevamiento.R;
import com.droidcba.techorelevamiento.features.families.add.FamilyAddActivity;

import java.util.List;

import rx.Subscriber;

public class FamilyListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private FamilyManager familyManager;
    private Subscriber<List<FamilyItem>> subscriber;

    public static FamilyListFragment newInstance() {
        FamilyListFragment fragment = new FamilyListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FamilyListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        familyManager = new FamilyManager();
    }

    @Override
    public void onResume() {
        super.onResume();
        setSubscriber();
        if (familyManager == null) {
            familyManager = new FamilyManager();
        }
        familyManager.getFamilies().subscribe(subscriber);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.family_list_fragment, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        FloatingActionButton fbFamilyAdd = (FloatingActionButton) view.findViewById(R.id.FamilyAdd);
        fbFamilyAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FamilyAddActivity.class));
            }
        });

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        setSubscriber();

        familyManager.getFamilies().subscribe(subscriber);

        return view;
    }

    private void setSubscriber() {
        subscriber = new Subscriber<List<FamilyItem>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getActivity(), "El servicio no esta disponible. Intentelo nuevamente mas tarde.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNext(List<FamilyItem> familyItems) {
                mAdapter = new FamilyAdapter(familyItems);
                mRecyclerView.setAdapter(mAdapter);
            }
        };
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }
    }

}
