package fos.com.atos.fositmanagement.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fos.com.atos.fositmanagement.R;
public class TicketDetailFragment extends Fragment {

    /**
     * Created by PARTH UNDAVIYA(A653821) on 2/02/17.
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_ticket_detail, container, false);

        TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addTab(tabLayout.newTab().setText("TICKET"));
        tabLayout.addTab(tabLayout.newTab().setText("ASSETS"));
        tabLayout.addTab(tabLayout.newTab().setText("ASSIGN"));
        tabLayout.addTab(tabLayout.newTab().setText("HISTORY"));
        tabLayout.addTab(tabLayout.newTab().setText("KNOWLEDGE"));
        tabLayout.addTab(tabLayout.newTab().setText("CHECKLIST"));

        final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.viewpager);

        viewPager.setAdapter(new PagerAdapter
                (getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return inflatedView;
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    TabFragment1 tab1 = new TabFragment1();
                    return tab1;
                case 1:
                    TabFragment2 tab2 = new TabFragment2();
                    return tab2;
                case 2:
                    TabFragment3 tab3 = new TabFragment3();
                    return tab3;
                case 3:
                    TabFragment4 tab4 = new TabFragment4();
                    return tab4;
                case 4:
                    TabFragment5 tab5 = new TabFragment5();
                    return tab5;
                case 5:
                    TabFragment6 tab6 = new TabFragment6();
                    return tab6;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("TICKET DETAILS");
    }
}