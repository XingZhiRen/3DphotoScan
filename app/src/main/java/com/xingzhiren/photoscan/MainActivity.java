package com.xingzhiren.photoscan;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ImageView> imageViewList;
    private int pagerWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager viewPager= (ViewPager) findViewById(R.id.viewPager);
        imageViewList=new ArrayList<ImageView>();
        ImageView first=new ImageView(MainActivity.this);
       first.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.huhu_1,MainActivity.this));
  //      first.setImageResource(R.mipmap.huhu_1);
        ImageView second=new ImageView(MainActivity.this);
       second.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.huhu_2,MainActivity.this));
//        second.setImageResource(R.mipmap.huhu_2);
        ImageView third=new ImageView(MainActivity.this);
        third.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.huhu_3,MainActivity.this));
 //       third.setImageResource(R.mipmap.huhu_3);
        ImageView fourth=new ImageView(MainActivity.this);
       fourth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.huhu_4,MainActivity.this));
//        fourth.setImageResource(R.mipmap.huhu_4);
        ImageView fifth=new ImageView(MainActivity.this);
        fifth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.huhu_5,MainActivity.this));
//        fifth.setImageResource(R.mipmap.huhu_5);
        imageViewList.add(first);
        imageViewList.add(second);
        imageViewList.add(third);
        imageViewList.add(fourth);
        imageViewList.add(fifth);
        viewPager.setOffscreenPageLimit(3);
        pagerWidth= (int) (getResources().getDisplayMetrics().widthPixels*3.0f/5.0f);
        ViewGroup.LayoutParams lp=viewPager.getLayoutParams();
        if (lp==null){
            lp=new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        }else {
            lp.width=pagerWidth;
        }
        viewPager.setLayoutParams(lp);
        viewPager.setPageMargin(-50);
        findViewById(R.id.activity_main).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return viewPager.dispatchTouchEvent(motionEvent);
            }
        });
        viewPager.setPageTransformer(true,new MyTransformation());
        viewPager.setAdapter(new MyPageAdapter(imageViewList));
    }

}
