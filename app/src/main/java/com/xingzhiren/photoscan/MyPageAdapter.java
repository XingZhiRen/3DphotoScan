package com.xingzhiren.photoscan;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Ren. on 2016/10/20.
 */
public class MyPageAdapter extends PagerAdapter {
    private List<ImageView> imageViewList;
    public MyPageAdapter(List<ImageView> imageViewList) {
        this.imageViewList=imageViewList;
    }

    @Override
    public int getCount() {
        return imageViewList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=imageViewList.get(position);
        container.addView(imageView,position);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViewList.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

}
