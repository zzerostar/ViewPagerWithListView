package com.zero.viewpagerlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @author zz
 * @date 2017/12/20
 */
public class DemoListAdapter extends BaseAdapter {

    private Context mContext;

    private List<DemoEntity> mData;

    public DemoListAdapter(Context context, List<DemoEntity> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public DemoEntity getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_item, null);
        }
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvContent = (TextView) convertView.findViewById(R.id.tv_content);
        DemoEntity demoEntity = getItem(position);
        tvTitle.setText(demoEntity.title);
        tvContent.setText(demoEntity.content);
        return convertView;
    }
}
