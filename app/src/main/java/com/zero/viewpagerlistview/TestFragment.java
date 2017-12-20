package com.zero.viewpagerlistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zz
 * @date 2017/12/20
 */
public class TestFragment extends Fragment {

    private ViewPager mViewPager;

    private List<View> mViewList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewList = new ArrayList<View>();
        View view1 = inflater.inflate(R.layout.simple_listview, null);
        View view2 = inflater.inflate(R.layout.simple_listview, null);
        ListView listView1 = (ListView) view1.findViewById(R.id.listview);
        ListView listView2 = (ListView) view2.findViewById(R.id.listview);

        mViewList.add(view1);
        mViewList.add(view2);

        listView1.setAdapter(new DemoListAdapter(getContext(), getMockData()));
        listView2.setAdapter(new DemoListAdapter(getContext(), getMockData()));

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mViewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViewList.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                View view = mViewList.get(position);
                container.removeView(view);
            }
        });
        return view;
    }


    private List<DemoEntity> getMockData() {
        List<DemoEntity> demoEntityList = new ArrayList<DemoEntity>();
        DemoEntity demoEntity;
        for (int i = 0; i < 20; i++) {
            demoEntity = new DemoEntity();
            demoEntity.title = "标题" + i;
            demoEntity.content = "这是一个很长的内容" + i;
            demoEntityList.add(demoEntity);
        }
        return demoEntityList;
    }

}
