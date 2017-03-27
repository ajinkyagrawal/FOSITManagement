package fos.com.atos.fositmanagement.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
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

public class TabFragment1 extends Fragment implements View.OnClickListener {
    private View v;
    private EditText fromDateEtxt;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.tab_fragment1, container, false);

        String [] values={"Assigned","Closed","Work in Progress","Pending"};
        Spinner spinner=(Spinner)v.findViewById(R.id.spn1);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        values = new String[]{"P1", "P2", "P3",};
        Spinner spinner2=(Spinner)v.findViewById(R.id.spn2);
        ArrayAdapter<String> adp= new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,values);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adp);

        dateFormatter = new SimpleDateFormat("E, dd MMM yyy", Locale.US);

        findViewsById();

        setDateTimeField();

        configureButton();
        return v;
    }
    public void configureButton() {
        final Button b1 = (Button) v.findViewById(R.id.recbutton);
        final Button b2 = (Button) v.findViewById(R.id.updateButton);
        final Button b3 = (Button) v.findViewById(R.id.ccButton);

        b1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                b1.setPressed(true);
                b2.setPressed(false);
                b3.setPressed(false);
                Toast.makeText(getActivity(), "You Clicked The RECONCILE BUTTON...!!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        b2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                b2.setPressed(true);
                b1.setPressed(false);
                b3.setPressed(false);
                Toast.makeText(getActivity(), "You Clicked The UPDATE BUTTON...!!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        b3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                b1.setPressed(false);
                b2.setPressed(false);
                b3.setPressed(true);
                Toast.makeText(getActivity(), "You Clicked The CHANGE CATEGORY BUTTON...!!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
    private void findViewsById() {
        fromDateEtxt = (EditText) v.findViewById(R.id.edt2);
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


}
