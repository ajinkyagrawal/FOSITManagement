package fos.com.atos.fositmanagement.adapter;

/**
 * Created by a596144 on 3/2/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import fos.com.atos.fositmanagement.R;
import fos.com.atos.fositmanagement.dto.SearchResults;

public class MyCustomBaseAdapter extends BaseAdapter {
    private static ArrayList<SearchResults> searchArrayList;

    private LayoutInflater mInflater;

    public MyCustomBaseAdapter(Context context, ArrayList<SearchResults> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_row_view, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtCityState = (TextView) convertView.findViewById(R.id.cityState);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.phone);
            holder.txtStatus = (TextView) convertView.findViewById(R.id.status);
            holder.txtDate = (TextView) convertView.findViewById(R.id.date);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.txtCityState.setText(searchArrayList.get(position).getCityState());
        holder.txtPhone.setText(searchArrayList.get(position).getPhone());
        holder.txtStatus.setText(searchArrayList.get(position).getStatus());
        holder.txtDate.setText(searchArrayList.get(position).getDate());


        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtCityState;
        TextView txtPhone;
        TextView txtStatus;
        TextView txtDate;
    }
}