package com.senon.mvpretrofitrx.mvp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.annotation.Nullable;

public class FirstFragment  extends Fragment {

    private String context="xxxxxxxxxxxxx";
    private TextView mTextView;
    //要显示的页面
    private int FragmentPage;

    public  static  FirstFragment newInstance(String context,int iFragmentPage){
        FirstFragment myFragment = new FirstFragment();
        myFragment.context = context;
        myFragment.FragmentPage = iFragmentPage;
        return  myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.context = context;
        View view = inflater.inflate(FragmentPage,container,false);
        //mTextView = (TextView)view.findViewById(R.id.titlename);
        //mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
        ///mTextView.setText(context);
        //mTextView.setBackgroundColor(20);
        return view;
    }
}
