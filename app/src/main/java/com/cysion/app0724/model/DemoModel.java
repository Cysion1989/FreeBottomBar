package com.cysion.app0724.model;

import android.util.Log;

import com.cysion.app0724.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/7/24 0024.
 */
public class DemoModel {

    public static String[] dataSet = {"龙珠", "柯南", "熊出没", "喜洋洋", "秦时明月", "倒霉熊", "爆笑虫子", "机器猫"};
    public static int[] drawSet = {R.drawable.home_selector, R.drawable.business_selector, R.drawable.find_selector, R.drawable.person_selector};
    public static int[] imgSet = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4};


    public static List<String> getData(int i) {

        List<String> list = new ArrayList<>();
        for (int i1 = 0; i1 < i; i1++) {
            String s = dataSet[new Random().nextInt(dataSet.length)];
            list.add(s);
            Log.e("flag--", "DemoModel--getData--23--" + s);
        }
        return list;

    }
}
