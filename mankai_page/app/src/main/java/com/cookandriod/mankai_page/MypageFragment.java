package com.cookandriod.mankai_page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MypageFragment extends Fragment {

    View view;

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mypage, container, false);

        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.tablayout);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("viewPager : "+viewPager);


//        tabLayout.setupWithViewPager(viewPager);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("RUN!!!!!!!!!!!!!!!!!!!!!!!");
                tabLayout.setupWithViewPager(viewPager);
//                tabLayout.setTabsFromPagerAdapter();
                setUpViewPager(viewPager);
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                System.out.println(tab);
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        System.out.println("viewPager : "+viewPager);
//        setUpViewPager(viewPager);
////        tabLayout.setupWithViewPager(viewPager);
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                System.out.println(tab);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                System.out.println(tab);
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                System.out.println(tab);
//            }
//        });
//
//    }

    private void setUpViewPager(ViewPager viewPager) {
        VPAdapter adapter = new VPAdapter(getChildFragmentManager());

        adapter.addFragment(new Mypage_followerFragment(), "tab1");
        adapter.addFragment(new Mypage_groupFragment(), "tab2");
        adapter.addFragment(new Mypage_postFragment(), "tab3");
        adapter.addFragment(new Mypage_memoFragment(), "tab4");

        viewPager.setAdapter(adapter);


    }

}


