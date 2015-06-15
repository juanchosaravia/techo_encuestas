package com.droidcba.techorelevamiento.features.families.add;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.droidcba.techorelevamiento.R;
import com.droidcba.techorelevamiento.core.BaseActivity;

public class FamilyAddActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeFragment(FamilyAddFragment.newInstance());
    }
}
