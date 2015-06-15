package com.droidcba.techorelevamiento.features.families.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.droidcba.techorelevamiento.R;
import com.droidcba.techorelevamiento.core.BaseFragment;
import com.droidcba.techorelevamiento.features.families.FamilyItem;
import com.droidcba.techorelevamiento.features.families.FamilyManager;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import rx.Subscriber;

public class FamilyAddFragment extends BaseFragment implements Validator.ValidationListener {

    @NotEmpty(messageResId = R.string.family_add_empty_field)
    @InjectView(R.id.FamilyAddFirstName)
    EditText etFirstName;
    @NotEmpty(messageResId = R.string.family_add_empty_field)
    @InjectView(R.id.FamilyAddLastName)
    EditText etLastName;
    @NotEmpty(messageResId = R.string.family_add_empty_field)
    @InjectView(R.id.FamilyAddStreet)
    EditText etStreet;
    @NotEmpty(messageResId = R.string.family_add_empty_field)
    @InjectView(R.id.FamilyAddStreetNumber)
    EditText etStreetNumber;
    @NotEmpty(messageResId = R.string.family_add_empty_field)
    @InjectView(R.id.FamilyAddPhone)
    EditText etPhone;
    @InjectView(R.id.FamilyAddCancel)
    Button btnCancel;
    @InjectView(R.id.FamilyAddAccept)
    Button btnAdd;

    private FamilyManager familyManager;
    private Subscriber<Void> subscriber;
    private Validator validator;

    public static FamilyAddFragment newInstance() {
        return new FamilyAddFragment();
    }

    public FamilyAddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.family_add_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListener.setActivityTitle(R.string.family_add_title);

        validator = new Validator(this);
        validator.setValidationListener(this);

        familyManager = new FamilyManager();
        subscriber = new Subscriber<Void>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getActivity(), "El servicio no esta disponible. Intentelo nuevamente mas tarde.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNext(Void aVoid) {
                Toast.makeText(getActivity(), "Familia agregada exitosamente!", Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        };
    }

    @OnClick(R.id.FamilyAddAccept)
    public void submit() {
        validator.validate();
    }

    @OnClick(R.id.FamilyAddCancel)
    public void cancel() {
        getActivity().finish();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        familyManager = null;
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }
    }

    @Override
    public void onValidationSucceeded() {
        //baseActions.hideKeyboard();
        FamilyItem familyItem = new FamilyItem();
        familyItem.setBossFirstName(etFirstName.getText().toString());
        familyItem.setBossLastName(etLastName.getText().toString());
        familyItem.setStreet(etStreet.getText().toString());
        familyItem.setStreetNumber(etStreetNumber.getText().toString());
        familyItem.setPhone(etPhone.getText().toString());
        familyItem.setLat("-31.438514");
        familyItem.setLng( "-64.188907");

        familyManager.addFamily(familyItem).subscribe(subscriber);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getActivity());

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
