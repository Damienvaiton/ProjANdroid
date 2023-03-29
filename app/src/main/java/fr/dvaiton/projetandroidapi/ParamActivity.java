package fr.dvaiton.projetandroidapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Switch;

import fr.dvaiton.projetandroidapi.Manager.CacheManager;

public class ParamActivity extends AppCompatActivity {

    Switch  darkmode;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param);

        darkmode = findViewById(R.id.DarkSwitch);

        darkmode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                CacheManager.getInstance().setDark(true);

            } else {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                CacheManager.getInstance().setDark(false);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        CacheManager cacheManager = CacheManager.getInstance();
        Boolean dark = cacheManager.getDark();
        if (dark) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            darkmode.setChecked(true);
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            darkmode.setChecked(false);
        }
    }
}