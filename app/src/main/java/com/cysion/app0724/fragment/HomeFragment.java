package com.cysion.app0724.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cysion.app0724.model.DemoModel;
import com.cysion.app0724.adapter.HomePagerAdapter;
import com.cysion.app0724.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/24 0024.
 */
public class HomeFragment extends Fragment {
    private View mView;
    private Activity mActivity;
    private ViewPager mViewPager;
    private boolean autoScroll;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (mViewPager != null) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                if (autoScroll) {
                    sendMessageToScroll();
                }
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.home_fragment, container, false);
        initView();
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    private void initView() {
        mViewPager = (ViewPager) mView.findViewById(R.id.vp_home_frag_banner);
        initViewPager();
    }

    private void initViewPager() {
        List<ImageView> data = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ImageView img = new ImageView(mActivity);
            img.setImageResource(DemoModel.imgSet[i]);
            data.add(img);
        }
        HomePagerAdapter adapter = new HomePagerAdapter(data);
        mViewPager.setAdapter(adapter);
    }

    private void sendMessageToScroll() {
        handler.sendEmptyMessageDelayed(0,3000);
        autoScroll = true;
    }

    @Override
    public void onStart() {
        super.onStart();
        sendMessageToScroll();
    }

    @Override
    public void onStop() {
        super.onStop();
        autoScroll = false;
    }
}
