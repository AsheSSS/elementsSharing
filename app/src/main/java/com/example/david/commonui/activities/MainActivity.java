package com.example.david.commonui.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.david.commonui.R;
import com.example.david.commonui.pagetransition.ChangeColor;
import com.example.david.commonui.viewcache.CommonViewCache;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTransiton();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                startActivity(new Intent(MainActivity.this, SecondActivity.class), ActivityOptions.makeSceneTransitionAnimation(this, v, "share").toBundle());
//                v.setBackgroundColor(0xff348902);
                break;
            case R.id.btn_two:
                startActivity(new Intent(MainActivity.this, ThirdActivity.class));
                break;
            case R.id.btn_three:
                CommonViewCache.tmpView = v;
                startActivity(new Intent(MainActivity.this, FourthActivity.class), ActivityOptions.makeSceneTransitionAnimation(this, v, "share").toBundle());
//                v.setBackgroundColor(0xff348902);
//                startActivity(new Intent(MainActivity.this, FourthActivity.class));
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setTransiton() {
//        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
//        getWindow().setAllowEnterTransitionOverlap(false);
//        getWindow().setAllowReturnTransitionOverlap(false);
//        Fade fade = new Fade();
//        fade.setDuration(800);
//        getWindow().setExitTransition(fade);
//
//
//        Slide slide = new Slide(Gravity.BOTTOM);
//        slide.setDuration(500);
//        getWindow().setReenterTransition(slide);
        ChangeColor changeColor = new ChangeColor();
        changeColor.setDuration(800);
        getWindow().setSharedElementExitTransition(changeColor);

    }
}
