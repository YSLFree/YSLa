package ysl.com.packagea.businessadapter;

/**
 * Created by free on 2017/12/31.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 功能：主页引导栏的三个Fragment页面设置适配器
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> mList;
    public FragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        mList = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    // start
    // 可以删除这段代码看看，数据源更新而viewpager不更新的情况
    private int mChildCount = 0;

    @Override
    public void notifyDataSetChanged() {
        // 重写这个方法，取到子Fragment的数量，用于下面的判断，以执行多少次刷新
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        if (mChildCount > 0) {
            // 这里利用判断执行若干次不缓存，刷新
            mChildCount--;
            // 返回这个是强制ViewPager不缓存，每次滑动都刷新视图
            return POSITION_NONE;
        }
        // 这个则是缓存不刷新视图
        return super.getItemPosition(object);
    }
    // end
}