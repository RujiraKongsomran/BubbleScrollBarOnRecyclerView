package com.rujirakongsomran.bubblescrollbaronrecyclerview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.AppBarLayout;

public class DescriptionActivity extends AppCompatActivity {
    private static final String TAG = "DescriptionActivity";
    AppBarLayout appBarLayout;
    androidx.appcompat.widget.Toolbar toolbar;
    TextView tvName;

    int colorOffset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("Profile");
        setSupportActionBar(toolbar);
        getSourceFromIntent();


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                colorOffset = -(verticalOffset);
                if (colorOffset > 255) {
                    colorOffset = 255;
                }
                // Hide toolbar
                toolbar.getBackground().setAlpha(colorOffset);
                toolbar.setAlpha(colorOffset / 256f);
            }
        });
    }

    private void getSourceFromIntent() {
        if (getIntent().hasExtra("name")) {
            String name = getIntent().getStringExtra("name");
            tvName = (TextView) findViewById(R.id.tvName);
            tvName.setText(name);
        }
    }

}