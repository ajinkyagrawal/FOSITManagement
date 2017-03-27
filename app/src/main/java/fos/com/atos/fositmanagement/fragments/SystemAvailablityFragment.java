package fos.com.atos.fositmanagement.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import fos.com.atos.fositmanagement.R;
import fos.com.atos.fositmanagement.adapter.SystemAvailiabilityArrayAdapter;

/**
 * Created by Belal on 18/09/16.
 */


public class SystemAvailablityFragment extends Fragment {
    private View v;
    static final String[] MOBILE_OS =
            new String[] { "INTERNET", "URA", "EXCHANGE SERVER", "BLACKBERRY","DHCP SERVER","STORAGE","PRINTSERVER","HUB"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        v = inflater.inflate(R.layout.fragment_system_availablity, container, false);
        final ListView lv = (ListView) v.findViewById(R.id.systemListView);
        lv.setAdapter(new SystemAvailiabilityArrayAdapter(getActivity(), MOBILE_OS));
        return v;
       // setListAdapter(new SystemAvailiabilityArrayAdapter(getActivity(), MOBILE_OS));
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("SYSTEM AVAILABLITY");
    }
}