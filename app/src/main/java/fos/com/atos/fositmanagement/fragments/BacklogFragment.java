package fos.com.atos.fositmanagement.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import fos.com.atos.fositmanagement.R;
import fos.com.atos.fositmanagement.adapter.MyCustomBaseAdapter;
import fos.com.atos.fositmanagement.dto.SearchResults;

public class BacklogFragment extends Fragment {

    private View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        v = inflater.inflate(R.layout.fragment_backlog, container, false);

        listdata();
        return v;
    }
    public void listdata() {
        ArrayList<SearchResults> searchResults = GetSearchResults();

        final ListView lv = (ListView) v.findViewById(R.id.srListView);
        lv.setAdapter(new MyCustomBaseAdapter(getActivity(), searchResults));


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv.getItemAtPosition(position);
                SearchResults fullObject = (SearchResults) o;
                FragmentManager fmm = getFragmentManager();
                FragmentTransaction ftt = fmm.beginTransaction();
                ftt.replace(R.id.content_frame, new TicketDetailFragment(), "");
                ftt.commit();
                Toast.makeText(getActivity(), "You have chosen: " + " " + fullObject.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private ArrayList<SearchResults> GetSearchResults() {
        ArrayList<SearchResults> results = new ArrayList<SearchResults>();
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        String formattedDate = df.format(c.getTime());
        SearchResults sr = new SearchResults();
        sr.setName("SRQ1105959");
        sr.setCityState("Status:Assigned(FOS)");
        sr.setPhone("Priority:P2");
        sr.setStatus("Assigned");
        sr.setDate("open date:"+formattedDate);
        results.add(sr);

        sr = new SearchResults();
        sr.setName("SRQ1105625");
        sr.setCityState("Status:Assigned(FOS)");
        sr.setPhone("Priority:P2");
        sr.setStatus("Assigned");
        sr.setDate("open date:"+formattedDate);
        results.add(sr);

        sr = new SearchResults();
        sr.setName("Lauren Sherman");
        sr.setCityState("Status:Assigned(FOS)");
        sr.setStatus("Assigned");
        sr.setDate("open date:"+formattedDate);
        sr.setPhone("Priority:P2");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("SRQ1106169");
        sr.setCityState("Status:Assigned(FOS)");
        sr.setStatus("Assigned");
        sr.setDate("open date:"+formattedDate);
        sr.setPhone("Priority:P2");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("SRQ1105960");
        sr.setCityState("Status:Assigned(FOS)");
        sr.setStatus("Assigned");
        sr.setDate("open date:"+formattedDate);
        sr.setPhone("Priority:P2");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("SRQ1105858");
        sr.setCityState("Status:Assigned(FOS)");
        sr.setStatus("Assigned");
        sr.setDate("open date:"+formattedDate);
        sr.setPhone("Priority:P2");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("SRQ1105961");
        sr.setCityState("Status:Assigned(FOS)");
        sr.setStatus("Assigned");
        sr.setDate("open date:"+formattedDate);
        sr.setPhone("Priority:P2");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("SRQ1105972");
        sr.setCityState("Status:Assigned(FOS)");
        sr.setStatus("Assigned");
        sr.setDate("open date:"+formattedDate);
        sr.setPhone("Priority:P2");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("SRQ1105966");
        sr.setCityState("Status:Assigned(FOS)");
        sr.setPhone("Priority:P2");
        sr.setStatus("Assigned");
        sr.setDate("open date:"+formattedDate);
        results.add(sr);

        sr = new SearchResults();
        sr.setName("SRQ1105965");
        sr.setCityState("Status:Assigned(FOS)");
        sr.setStatus("Assigned");
        sr.setDate("open date:"+formattedDate);
        sr.setPhone("Priority:P2");
        results.add(sr);

        return results;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("BACKLOG");
    }
}
