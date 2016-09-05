package app.tangya.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.tangya.com.entity.TourInfo;
import app.tangya.com.myapp50.R;


/**
 * Created by Administrator on 2016/8/28.
 */
public class TourAdapter extends BaseAdapter{
    Context context;
    LayoutInflater inflater;
    ArrayList<TourInfo> list = new ArrayList<TourInfo>();
    public TourAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public void addDataToAdapter(TourInfo info) {
        if (info != null) {
            list.add(info);
        }
    }
    public void addDataToAdapter(List<TourInfo> list1) {
        list.addAll(list1);
    }
    public void clearDataToAdapter() {
        list.clear();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view==null){
            view=inflater.inflate(R.layout.main2,null);
        }
        TextView textView= (TextView) view.findViewById(R.id.textView);
        textView.setText(list.get(position).locality);
        return view;
    }
}
