package com.example.lfy.dlvideo.fragment_home.child_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lfy.dlvideo.R;
import com.example.lfy.dlvideo.guide.GuideInto;
import com.example.lfy.dlvideo.utils.HttpAddress;
import com.example.lfy.dlvideo.utils.http.BaseCallback;
import com.example.lfy.dlvideo.utils.http.OkHttpHelper;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lfy on 2016/8/10.
 */
public class FirstFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    private static final String ARG_SECTION_NUMBER = "section_number";

    private RecyclerView child_recycler;
    FirstAdapter firstAdapter;

    public FirstFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FirstFragment newInstance(int sectionNumber) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.child_fragment, container, false);
        child_recycler = (RecyclerView) rootView.findViewById(R.id.child_recycler);
        firstAdapter = new FirstAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        child_recycler.setAdapter(firstAdapter);


//        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), GuideInto.class);
//                startActivity(intent);
//            }
//        });


        return rootView;
    }

}
