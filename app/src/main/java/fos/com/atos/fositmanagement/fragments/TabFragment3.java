package fos.com.atos.fositmanagement.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import fos.com.atos.fositmanagement.R;
/**
 * Created by PARTH UNDAVIYA(A653821) on 27/02/17.
 */

public class TabFragment3 extends Fragment {

    private View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.tab_fragment3, container, false);

        Spinner spinner3=(Spinner)v.findViewById(R.id.spn3);


        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1; // you dont display last item. It is used as hint.
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner3.setAdapter(adapter);
        adapter.add("User 1");
        adapter.add("User 2");
        adapter.add("User 3");
        adapter.add("Select an User");

        spinner3.setAdapter(adapter);
        spinner3.setSelection(adapter.getCount());
        configureButton();
        return v;
    }

    public void configureButton()
    {
        final Button b4=(Button)v.findViewById(R.id.cancelButton);
        final   Button b5=(Button)v.findViewById(R.id.assignButton);
        b4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                b4.setPressed(true);
                b5.setPressed(false);
                Toast.makeText(getActivity(),"You Clicked The CANCEL BUTTON...!!",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        b5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                b5.setPressed(true);
                b4.setPressed(false);
                Toast.makeText(getActivity(),"You Clicked The ASSIGN BUTTON...!!",Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }
}
