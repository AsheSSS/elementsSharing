package com.example.david.commonui.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.example.david.commonui.R;
import com.example.david.commonui.fragment.DetailFragment;
import com.example.david.commonui.viewcache.CommonViewCache;

public class FourthActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        DetailFragment detailFragment = DetailFragment.newInstance(0);
        // 替换Fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .addSharedElement(CommonViewCache.tmpView, "share")
                    .add(R.id.main_cl_container, detailFragment)
                    .commit();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }
}
