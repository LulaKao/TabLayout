package com.example.tablayouttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,
        TabLayout.OnTabSelectedListener{
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private Fragment_item1 fragment1 = new Fragment_item1();
    private Fragment_item2 fragment2 = new Fragment_item2();
    private Fragment_item3 fragment3 = new Fragment_item3();

    //============== onCreate START ==============//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 宣告元件
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        // 註冊監聽
        viewPager.addOnPageChangeListener(this);
        tabLayout.addOnTabSelectedListener(this);

        // 添加適配器，在 viewPager 裡引入 Fragment
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return fragment1;
                    case 1:
                        return fragment2;
                    case 2:
                        return fragment3;
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }
    //============== onCreate END ==============//

    //============== implement methods START ==============//
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        // viewPager 滑動之後觸發 -> 讓 tab 下方的 indicator 要跟著選中的 tab 移動
        tabLayout.getTabAt(position).select();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        // TabLayout 裡的 TabItem 被選中的時候觸發 -> 讓 viewPager 換頁
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    //============== implement methods END ==============//
}
