package com.example.david.commonui.fragment;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.david.commonui.R;


/**
 * 详情页面
 * <p/>
 * Created by wangchenlong on 15/11/5.
 */
public class DetailFragment extends Fragment {

    private static final String ARG_NUMBER = "arg_number";

    ImageView mImage;


    /**
     * 根据选择的number, 选择展示的数据
     *
     * @param number 数字
     * @return 详情页面
     */
    public static DetailFragment newInstance(@IntRange(from = 0, to = 5) int number) {
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_NUMBER, number);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        mImage = (ImageView) view.findViewById(R.id.detail_image);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
