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
import android.widget.Button;
import android.widget.Toast;

import fos.com.atos.fositmanagement.R;
public class MyTasksFragment extends Fragment {

    /**
     * Created by PARTH UNDAVIYA(A653821) on 2/02/17.
     */
    private View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.fragment_my_tasks, container, false);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tabss);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.addTab(tabLayout.newTab().setText("TICKET"));
        tabLayout.addTab(tabLayout.newTab().setText("EMPLOYEE"));
        tabLayout.addTab(tabLayout.newTab().setText("COMMENTS"));


        final ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewpagerr);

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


        return v;
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
                    TabFragment7 tab7 = new TabFragment7();
                    return tab7;
                case 1:
                    TabFragment8 tab8 = new TabFragment8();
                    return tab8;
                case 2:
                    TabFragment9 tab9 = new TabFragment9();
                    return tab9;

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
        getActivity().setTitle("TASK DETAILS");
    }
}