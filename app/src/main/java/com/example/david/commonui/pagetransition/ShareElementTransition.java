package com.example.david.commonui.pagetransition;

import android.os.Bundle;
import android.view.View;

import com.example.david.commonui.activities.BaseActivity;
import com.example.david.commonui.R;


public class ShareElementTransition extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_transition);

        getWindow().getDecorView().setVisibility(View.VISIBLE);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
                findViewById(R.id.back).setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }
}
