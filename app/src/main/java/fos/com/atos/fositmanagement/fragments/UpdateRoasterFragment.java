package fos.com.atos.fositmanagement.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import fos.com.atos.fositmanagement.R;


/**
 * Created by PARTH UNDAVIYA(A653821) on 27/02/17.
 */



public class UpdateRoasterFragment extends Fragment implements View.OnClickListener {

    private EditText fromDateEtxt;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    private View v;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_update_roaster, container, false);

        String [] values={"PARTH UNDAVIYA","AJINKYA AGRAWAL"};
        Spinner spinner=(Spinner)v.findViewById(R.id.spn4);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        values = new String[]{"SL.Mumbai ", "SL.Gujarat", "SL.Pune",};
        Spinner spinner2=(Spinner)v.findViewById(R.id.spn5);
        ArrayAdapter<String> adp= new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,values);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adp);

        values = new String[]{"A", "B", "C","D","E"};
        Spinner spinner3=(Spinner)v.findViewById(R.id.spn6);
        ArrayAdapter<String> adpp= new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,values);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adpp);



        dateFormatter = new SimpleDateFormat("E, dd MMM yyy", Locale.US);

        findViewsById();
        configureButton();
        setDateTimeField();
        return v;

    }

    public void configureButton(){

        final Button b6=(Button)v.findViewById(R.id.update2Button);

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"You Clicked The UPDATE BUTTON...!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findViewsById() {
        fromDateEtxt = (EditText) v.findViewById(R.id.edittext);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();


    }
    private void setDateTimeField() {
        fromDateEtxt.setOnClickListener(this);


        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


    }

    @Override
    public void onClick(View v) {
        if(v == fromDateEtxt) {
            fromDatePickerDialog.show();
        } else {
        }

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("UPDATE ROASTER");
    }
}