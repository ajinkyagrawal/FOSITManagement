package fos.com.atos.fositmanagement.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import fos.com.atos.fositmanagement.R;

public class TabFragment7 extends Fragment {

    private View v;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.tab_fragment7, container, false);
        String [] values={"Assigned","Closed","Work in Progress","Pending"};
        Spinner spinner7=(Spinner)v.findViewById(R.id.spn7);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter);
        configureButton();
        return  v;
    }
    public void configureButton(){

        final Button b9=(Button)v.findViewById(R.id.compltButton);

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"You Clicked The COMPLETE BUTTON...!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
