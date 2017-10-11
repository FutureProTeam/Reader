package com.futureproteam.reader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.futureproteam.reader.R;
import com.futureproteam.reader.base.BaseFragment;

/**
 * 智能导入
 * Created by ding-syi on 2017/10/11.
 */

public class IntelligentImportFragment extends BaseFragment {
    private static String FRAGMENT_TITLE= "智能导入书籍";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intelligent_import, container, false);
        return view;
    }
}
