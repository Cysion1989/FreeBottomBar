package com.cysion.app0724.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cysion.app0724.model.DemoModel;
import com.cysion.app0724.fragment.HomeFragment;
import com.cysion.app0724.view.MyViewPager;
import com.cysion.app0724.adapter.MyViewPagerAdapter;
import com.cysion.app0724.R;
import com.cysion.app0724.fragment.SampleFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private ListView mMenuList;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        //list
        initMenuList();
        //vp
        initViewPager();
        // reset ok?
    }

    private void initMenuList() {
        List<String> menuData = DemoModel.getData(6);
        ArrayAdapter<String> stringAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuData);
        mMenuList.setAdapter(stringAdapter);
    }

    private void initViewPager() {
        List<Fragment> mMainFragments = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        mMainFragments.add(0, homeFragment);
        for (int i = 1; i < 4; i++) {
            SampleFragment fragment = new SampleFragment();
            mMainFragments.add(fragment);
        }

        List<String> titles = DemoModel.getData(4);
        MyViewPagerAdapter viewAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mMainFragments, titles);
        mViewPager.setAdapter(viewAdapter);
        mViewPager.setOffscreenPageLimit(5);
        mTabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setIcon(DemoModel.drawSet[i]);
            mTabLayout.getTabAt(i).setCustomView(R.layout.tabitem_main);
        }
        //test02 forget commit
        mTabLayout.getTabAt(0).getCustomView().setSelected(true);
    }

    private void initView() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        mMenuList = (ListView) findViewById(R.id.list_drawer_items);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        mViewPager = (MyViewPager) findViewById(R.id.vp_main);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout_main);
        //test01 forget commit

    }
}
