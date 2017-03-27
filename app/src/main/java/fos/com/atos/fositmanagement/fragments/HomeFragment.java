package fos.com.atos.fositmanagement.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import fos.com.atos.fositmanagement.R;

import fos.com.atos.fositmanagement.activity.HomeActivity;

/**
 * Created by PARTH UNDAVIYA(A653821) on 18/09/16.
 */
public class HomeFragment extends Fragment{

    private View v;



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

         v = inflater.inflate(R.layout.fragment_home, container, false);
        configureImageButton();
        return v;
    }
    private void configureImageButton() {
        // TODO Auto-generated method stub
        ImageButton btn1 = (ImageButton) v.findViewById(R.id.ib1);
        ImageButton btn2 = (ImageButton) v.findViewById(R.id.ib2);
        ImageButton btn3 = (ImageButton) v.findViewById(R.id.ib3);
        ImageButton btn4 = (ImageButton) v.findViewById(R.id.ib4);
        ImageButton btn5 = (ImageButton) v.findViewById(R.id.ib5);
        ImageButton btn6 = (ImageButton) v.findViewById(R.id.ib6);
        ImageButton btn7 = (ImageButton) v.findViewById(R.id.ib7);
        ImageButton btn8 = (ImageButton) v.findViewById(R.id.ib8);
        ImageButton btn9 = (ImageButton) v.findViewById(R.id.ib9);
        ImageButton btn10 = (ImageButton) v.findViewById(R.id.ib10);
        ImageButton btn11 = (ImageButton) v.findViewById(R.id.ib11);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_frame,new DashboardFragment(),"");
                ft.commit();
                Toast.makeText(getActivity(), "You Clicked the button!", Toast.LENGTH_LONG).show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_frame,new SystemAvailablityFragment(),"");
                ft.commit();
                Toast.makeText(getActivity(), "You Clicked the button!", Toast.LENGTH_LONG).show();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_frame,new MyTicketsFragment(),"");
                ft.commit();
                Toast.makeText(getActivity(), "You Clicked the button!", Toast.LENGTH_LONG).show();

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_frame,new AssetsFragment(),"");
                ft.commit();
                Toast.makeText(getActivity(), "You Clicked the button!", Toast.LENGTH_LONG).show();

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_frame,new BacklogFragment(),"");
                ft.commit();
                Toast.makeText(getActivity(), "You Clicked the button!", Toast.LENGTH_LONG).show();

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_frame,new MessageHubFragment(),"");
                ft.commit();
                Toast.makeText(getActivity(), "You Clicked the button!", Toast.LENGTH_LONG).show();

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_frame,new MyGroupsFragment(),"");
                ft.commit();
                Toast.makeText(getActivity(), "You Clicked the button!", Toast.LENGTH_LONG).show();

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_frame,new MyTasksFragment(),"");
                ft.commit();
                Toast.makeText(getActivity(), "You Clicked the button!", Toast.LENGTH_LONG).show();

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_frame,new MyActivitiesFragment(),"");
                ft.commit();
                Toast.makeText(getActivity(), "You Clicked the button!", Toast.LENGTH_LONG).show();

            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_frame,new UpdateRoasterFragment(),"");
                ft.commit();
                Toast.makeText(getActivity(), "You Clicked the button!", Toast.LENGTH_LONG).show();

            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.content_frame,new MyProfileFragment(),"");
                ft.commit();
                Toast.makeText(getActivity(), "You Clicked the button!", Toast.LENGTH_LONG).show();

            }
        });
    }
    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("DASHBOARD");
    }
}
