package com.example.david.commonui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.commonui.R;


/**
 * 网格的RecyclerView
 * <p/>
 * Created by wangchenlong on 15/11/5.
 */
public class Fragment_ReplaceA extends Fragment implements View.OnClickListener {

    View btn_a;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        btn_a = view.findViewById(R.id.btn_a);

        //這句話沒什麼用
        ViewCompat.setTransitionName(btn_a,  "btn_a");
        btn_a.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {
        DetailFragment detailFragment = DetailFragment.newInstance(0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            detailFragment.setSharedElementEnterTransition(new DetailTransition());
            detailFragment.setExitTransition(new Fade());
            detailFragment.setEnterTransition(new Fade());
            detailFragment.setSharedElementReturnTransition(new DetailTransition());
        }

        getActivity().getSupportFragmentManager().beginTransaction()
                .addSharedElement(btn_a, "share")
                .replace(R.id.main_cl_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }
}
