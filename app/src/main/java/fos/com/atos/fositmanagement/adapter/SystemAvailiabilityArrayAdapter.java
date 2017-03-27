package fos.com.atos.fositmanagement.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import fos.com.atos.fositmanagement.R;

/**
 * Created by a596144 on 3/2/2017.
 */

public class SystemAvailiabilityArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public SystemAvailiabilityArrayAdapter(Context context, String[] values) {
        super(context, R.layout.custom_systemavailability_row_view, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.custom_systemavailability_row_view, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        TextView imageView = (TextView) rowView.findViewById(R.id.logo);
        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];

        System.out.println(s);

        if (s.equals("INTERNET")) {
            imageView.setBackgroundColor(Color.parseColor("#26A65B"));
        } else if (s.equals("URA")) {
            imageView.setBackgroundColor(Color.parseColor("#26A65B"));
        } else if (s.equals("EXCHANGE SERVER")) {
            imageView.setBackgroundColor(Color.parseColor("#D91E18"));
        }else if (s.equals("BLACKBERRY")) {
            imageView.setBackgroundColor(Color.parseColor("#F9BF3B"));
        }else if (s.equals("DHCP SERVER")) {
            imageView.setBackgroundColor(Color.parseColor("#D91E18"));
        }else if (s.equals("STORAGE")) {
            imageView.setBackgroundColor(Color.parseColor("#D91E18"));
        }else if (s.equals("PRINTSERVER")) {
            imageView.setBackgroundColor(Color.parseColor("#D91E18"));
        }else if (s.equals("HUB")) {
            imageView.setBackgroundColor(Color.parseColor("#D91E18"));
        }
        else {
//            imageView.setImageResource(R.drawable.android_logo);
        }

        return rowView;
    }
}