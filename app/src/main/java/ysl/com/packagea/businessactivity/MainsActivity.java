package ysl.com.packagea.businessactivity;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import ysl.com.packagea.businessadapter.FragmentAdapter;
import ysl.com.packagea.businessfragment.KaiJiangFragment;
import ysl.com.packagea.businessfragment.NewsFragment;
import ysl.com.packagea.businessfragment.SetFragment;
import ysl.com.packagea.businessfragment.ZouShiFragment;
import ysl.com.packagea.jpushdemo.R;
import ysl.com.packagea.utils.FixedSpeedScroller;

/**
 * Created by free on 2017/12/31.
 */

public class MainsActivity extends AppCompatActivity {
    private TextView news,kaijiang,seting,zoushi,title;
    private List<Fragment> fragments=new ArrayList<>();
    private FragmentAdapter mAdapter;
    private ViewPager idViewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainsactivity);
        news=findViewById(R.id.news);
        kaijiang=findViewById(R.id.kaijiang);
        seting=findViewById(R.id.seting);
        zoushi=findViewById(R.id.zoushi);
        title=findViewById(R.id.title);
        idViewpager=findViewById(R.id.id_viewpager);
        initFragment();
    }
    private void initFragment() {
        fragments.add(new KaiJiangFragment());
        fragments.add(new NewsFragment());
        fragments.add(new ZouShiFragment());
        fragments.add(new SetFragment());
        /**
         * 初始化Adapter
         */
        mAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        setViewPagerScrollSpeed();
        idViewpager.setAdapter(mAdapter);
        idViewpager.setOffscreenPageLimit(4);
        idViewpager.addOnPageChangeListener(new TabOnPageChangeListener());
        switchToCurrent(R.id.news);
    }
    private void switchToCurrent(int id) {
        news.setTextColor(getResources().getColor(R.color.black_87));
        kaijiang.setTextColor(getResources().getColor(R.color.black_87));
        seting.setTextColor(getResources().getColor(R.color.black_87));
        zoushi.setTextColor(getResources().getColor(R.color.black_87));
        news.setCompoundDrawables(null, getSwitchDrawable(R.mipmap.ic_launcher), null, null);
        kaijiang.setCompoundDrawables(null, getSwitchDrawable(R.mipmap.ic_launcher), null, null);
        seting.setCompoundDrawables(null, getSwitchDrawable(R.mipmap.ic_launcher), null, null);
        zoushi.setCompoundDrawables(null, getSwitchDrawable(R.mipmap.ic_launcher), null, null);
        switch (id) {
            case R.id.news: {
                title.setText("头条");
                news.setTextColor(getResources().getColor(R.color.coloryslred));
                news.setCompoundDrawables(null, getSwitchDrawable(R.drawable.notification), null, null);
                break;
            }
            case R.id.zoushi: {
                title.setText("走势");
                zoushi.setTextColor(getResources().getColor(R.color.coloryslred));
                zoushi.setCompoundDrawables(null, getSwitchDrawable(R.drawable.notification), null, null);
                break;
            }
            case R.id.kaijiang_layout: {
                title.setText("开奖");
                kaijiang.setTextColor(getResources().getColor(R.color.coloryslred));
                kaijiang.setCompoundDrawables(null, getSwitchDrawable(R.drawable.notification), null, null);
                break;
            }
            case R.id.seting_layout: {
                title.setText("设置");
                seting.setTextColor(getResources().getColor(R.color.coloryslred));
                seting.setCompoundDrawables(null, getSwitchDrawable(R.drawable.notification), null, null);
                break;
            }
        }
    }
    /**
     * 设置滚动速度
     */
    private void setViewPagerScrollSpeed() {
        try {
            Field mScroller = null;
            mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(idViewpager.getContext());
            mScroller.set(idViewpager, scroller);
        } catch (NoSuchFieldException e) {

        } catch (IllegalArgumentException e) {

        } catch (IllegalAccessException e) {

        }
    }
    private Drawable getSwitchDrawable(final int mipmapId) {
        Drawable img_off;
        img_off = getResources().getDrawable(mipmapId);
        img_off.setBounds(0, 0, img_off.getMinimumWidth(), img_off.getMinimumHeight());
        return img_off;
    }
    /**
     * 功能：Fragment页面改变事件
     */
    private class TabOnPageChangeListener implements ViewPager.OnPageChangeListener {

        //当滑动状态改变时调用
        public void onPageScrollStateChanged(int state) {

        }

        //当前页面被滑动时调用
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        //当新的页面被选中时调用
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    title.setText("新闻");
                    switchToCurrent(R.id.news);
                    break;
                case 1:
                    title.setText("走势");
                    switchToCurrent(R.id.zoushi);
                    break;
                case 2:
                    title.setText("开奖");
                    switchToCurrent(R.id.kaijiang_layout);
                    break;
                case 3:
                    title.setText("设置");
                    switchToCurrent(R.id.seting_layout);
                    break;
            }
        }
    }
}
