package com.cysion.app0724.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/24 0024.
 */
public class HomePagerAdapter extends PagerAdapter {

    List<ImageView> imgs;

    public HomePagerAdapter(List<ImageView> data) {
        imgs = data;
    }

    @Override
    public int getCount() {
        return 88888888;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.e("flag--","HomePagerAdapter--instantiateItem--35--");
        View view = imgs.get(position%imgs.size());
        if (view.getParent() != null) {
            ((ViewGroup) (view.getParent())).removeView(view);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imgs.get(position%imgs.size()));
    }

}
