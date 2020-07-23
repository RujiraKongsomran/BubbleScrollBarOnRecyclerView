package com.rujirakongsomran.bubblescrollbaronrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;

public class DescriptionActivity extends AppCompatActivity {
    AppBarLayout appBarLayout;
    Toolbar toolbar;

    int colorOffset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        //toolbar.setTitle("AndroidSpread");

        //setSupportActionBar(toolbar);

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
}