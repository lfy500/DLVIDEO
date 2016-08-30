package com.example.lfy.dlvideo.fragment_home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lfy.dlvideo.bean.FirstBean;
import com.example.lfy.dlvideo.fragment_home.child_fragment.FirstFragment;
import com.example.lfy.dlvideo.fragment_home.child_fragment.SecondFragment;
import com.example.lfy.dlvideo.R;
import com.example.lfy.dlvideo.fragment_home.child_fragment.ThirdFragment;
import com.example.lfy.dlvideo.utils.HttpAddress;
import com.example.lfy.dlvideo.utils.ToastUtils;
import com.example.lfy.dlvideo.utils.http.BaseCallback;
import com.example.lfy.dlvideo.utils.http.OkHttpHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by WangChang on 2016/5/15.
 */
public class HomeFragment extends Fragment {

    FirstFragment firstFragment;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;

    List<Fragment> fragmentList;
    private OkHttpHelper okHttpHelper = OkHttpHelper.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        fragmentList = getFragments();

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.container);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Log.d("我是还没开始", "开始请求");
                okHttpHelper.get(HttpAddress.time, new BaseCallback<String>() {
                    @Override
                    public void onRequestBefore(Request request) {
                        Log.d("我是开始", "开始请求");
                    }

                    @Override
                    public void onFailure(Request request, IOException e) {
                        Log.d("我是失败", e.toString());
                    }

                    @Override
                    public void onSuccess(Response response, String o) {
                        ToastUtils.showToast(getActivity(), o.toString());
                        Log.d("我是成功", "没有打印信息");
                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        Log.d("我是成功失败", e.toString());
                    }
                });
            }
        });
        return view;
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        firstFragment = FirstFragment.newInstance(1);
        secondFragment = SecondFragment.newInstance(2);
        thirdFragment = ThirdFragment.newInstance(3);

        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);
        return fragments;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        TextView tv = (TextView) getActivity().findViewById(R.id.tv);
//        tv.setText(getArguments().getString("ARGS"));
    }

    public static HomeFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return fragmentList.size();
        }

        //此方法用来显示tab上的名字
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "直播";
                case 1:
                    return "课程";
                case 2:
                    return "活动";
            }
            return null;
        }
    }
}
